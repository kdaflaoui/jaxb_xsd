package kd.develop.demo;

import com.kdevelop.orders.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    Jaxb2Marshaller marshaller;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order();
        order.setOrderid(UUID.randomUUID().toString());
        order.setProduct("Spring boot App");
        Order.Address address = new Order.Address();
        address.setAddress("2515 one street");
        address.setCountry("CA");
        address.setName("Kdevelop");
        address.setCity("Quebec");
        order.setAddress(address);

        StringWriter writer = new StringWriter();
        marshaller.marshal(order, new StreamResult(writer));
        String xml = writer.toString();
        System.out.println("ceci est un writer /n" + writer);
        System.out.println("ceci est un xml /n" + xml);
        log.info("XML : {}", xml);

    }
}
