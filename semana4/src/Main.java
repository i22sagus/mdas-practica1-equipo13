import dominio.*;
import proveedores.*;
import catalogos.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE CATÁLOGO DE MUEBLES ===");

        // 1. Crear productos de prueba
        // NOTA: Creamos dos sofás con el MISMO ID ("S1") para probar que el stock se suma
        Sofa sofa1_A = new Sofa("S1", "Sofá Nube", 450.0, 10, "Tela", "Gris", 3);
        Sofa sofa1_C = new Sofa("S1", "Sofá Nube", 460.0, 5, "Tela", "Gris", 3); // Mismo sofá, distinto proveedor
        
        Sofa sofa2 = new Sofa("S2", "Sofá Relax", 600.0, 2, "Piel", "Negro", 2);
        
        Mesa mesa1 = new Mesa("M1", "Mesa Comedor", 150.0, 20, "Madera", "Roble", "200x100");
        Mesa mesa2 = new Mesa("M2", "Mesa Oficina", 80.0, 50, "Metal", "Blanco", "120x60");

        // 2. Instanciar y cargar proveedores según la configuración del enunciado
        EmpresaA_Sofas empresaA = new EmpresaA_Sofas();
        empresaA.agregarSofa(sofa1_A); 
        empresaA.agregarSofa(sofa2);   // Empresa "A" vende únicamente sofás [cite: 62]

        EmpresaB_Mesas empresaB = new EmpresaB_Mesas();
        empresaB.agregarMesa(mesa1);   // Empresa "B" vende únicamente mesas [cite: 63]

        EmpresaC_Multiproducto empresaC = new EmpresaC_Multiproducto();
        empresaC.agregarSofa(sofa1_C); // Empresa "C" vende tanto mesas como sofás [cite: 64]
        empresaC.agregarMesa(mesa2);

        // 3. Configurar los catálogos de la empresa (La Abstracción)
        CatalogoSofas catalogoSofas = new CatalogoSofas();
        catalogoSofas.agregarProveedor(empresaA);
        catalogoSofas.agregarProveedor(empresaB); // Se añade B aunque no venda sofás para probar la robustez
        catalogoSofas.agregarProveedor(empresaC);

        CatalogoMesas catalogoMesas = new CatalogoMesas();
        catalogoMesas.agregarProveedor(empresaA); // Se añade A aunque no venda mesas
        catalogoMesas.agregarProveedor(empresaB);
        catalogoMesas.agregarProveedor(empresaC);

        // --- PRUEBAS DE FUNCIONALIDAD ---

        System.out.println("\n--- BÚSQUEDA ESPECÍFICA (Sofás de 3 plazas) ---");
        List<Sofa> sofas3Plazas = catalogoSofas.buscarPorPlazas(3);
        for (Sofa s : sofas3Plazas) {
            System.out.println("- " + s.getId() + " | " + s.getNombre() + " | Stock: " + s.getUnidades());
        }

        System.out.println("\n--- BÚSQUEDA ORDENADA POR PRECIO (Menor a Mayor) ---");
        // Debería agregar los resultados de todas las empresas disponibles [cite: 58]
        List<Producto> porPrecio = catalogoSofas.buscarOrdenadoPorPrecio(); 
        for (Producto p : porPrecio) {
            System.out.println("- " + p.getNombre() + " | Precio: " + p.getPrecio() + "€");
        }

        System.out.println("\n--- BÚSQUEDA ORDENADA POR STOCK (Mayor a Menor con Suma) ---");
        // Se deberán agregar las unidades del mismo producto que estén disponibles en más de una empresa [cite: 60]
        List<Producto> porStock = catalogoSofas.buscarOrdenadoPorStock();
        for (Producto p : porStock) {
            // El Sofá "S1" debería mostrar 15 unidades (10 de la Empresa A + 5 de la Empresa C)
            System.out.println("- " + p.getNombre() + " (" + p.getId() + ") | Stock Total: " + p.getUnidades());
        }
    }
}