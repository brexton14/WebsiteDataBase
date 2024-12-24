package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.inhousePartRepository = inhousePartRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (partRepository.count() == 0) {
            InhousePart ip1 = new InhousePart();
            ip1.setId(1L);
            ip1.setName("O-Rings");
            ip1.setPrice(1.50);
            ip1.setInv(10);
            ip1.setMinInv(1);
            ip1.setMaxInv(150);

            InhousePart ip2 = new InhousePart();
            ip2.setId(2L);
            ip2.setName("Metal Bumper Stickers");
            ip2.setPrice(6);
            ip2.setInv(40);
            ip2.setMinInv(1);
            ip2.setMaxInv(150);

            OutsourcedPart op1 = new OutsourcedPart();
            op1.setCompanyName("CompleteNewParts");
            op1.setName("DiamondBack Fender");
            op1.setInv(10);
            op1.setPrice(2000.0);
            op1.setId(101L);
            op1.setMinInv(1);
            op1.setMaxInv(150);

            OutsourcedPart op2 = new OutsourcedPart();
            op2.setCompanyName("RipOffCarParts");
            op2.setName("Plastic Wheel Cover");
            op2.setInv(5);
            op2.setPrice(150.0);
            op2.setId(102L);
            op2.setMinInv(1);
            op2.setMaxInv(150);

            OutsourcedPart op3 = new OutsourcedPart();
            op3.setCompanyName("FasterCars");
            op3.setName("MAX Turbo 360");
            op3.setInv(15);
            op3.setPrice(15000.0);
            op3.setId(103L);
            op3.setMinInv(1);
            op3.setMaxInv(150);

            inhousePartRepository.save(ip1);
            inhousePartRepository.save(ip2);
            outsourcedPartRepository.save(op1);
            outsourcedPartRepository.save(op2);
            outsourcedPartRepository.save(op3);
        }
        if (productRepository.count() == 0) {
            Product transFluid = new Product(9,"Transmission Fluid", 25.00, 10);
            Product oil = new Product(10,"Oil", 30.00, 30);
            Product gas = new Product(11,"Gasoline", 3.50, 100);
            Product recharge = new Product(12,"R-120", 40.00, 5);
            Product lube = new Product(13,"WD-140", 5.00, 20);

            productRepository.save(transFluid);
            productRepository.save(oil);
            productRepository.save(gas);
            productRepository.save(recharge);
            productRepository.save(lube);
        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());



    }
}