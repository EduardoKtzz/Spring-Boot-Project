package com.klitzke.aula.config;

import com.klitzke.aula.Enums.OrderStatus;
import com.klitzke.aula.entities.*;
import com.klitzke.aula.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepositoty orderRepositoty;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    //Tudo que for colocado aqui dentro, vai ser implementado quando o objeto for reiniciado
    @Override
    public void run(String... args) throws Exception {

        //Instanciando usuários para o banco de dados
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Instanciando pedidos para o banco de dados
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

        //Instanciando categorias de produtos para o banco de dados
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        //Instanciando produtos para o banco de dados
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        //Inserindo no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepositoty.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        //Fazendo uma associação de objetos, produtos e categorias
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        //Salvando associações no banco de dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        //Instanciando para o banco de dados
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        //Inserindo no banco de dados
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        //Instanciando um pagamento para o pedido -Um para um
        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
        o1.setPayment(pay1);

        //Inserindo no banco de dados
        orderRepositoty.save(o1);



    }
}
