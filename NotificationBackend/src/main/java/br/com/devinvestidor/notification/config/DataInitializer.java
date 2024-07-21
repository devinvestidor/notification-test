package br.com.devinvestidor.notification.config;

import br.com.devinvestidor.notification.dao.CategoryDAOImpl;
import br.com.devinvestidor.notification.dao.UserDAOImpl;
import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.Channel;
import br.com.devinvestidor.notification.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(CategoryDAOImpl categoryDAO, UserDAOImpl userDAO) {
        return args -> {
            categoryDAO.persist(new Category(1L, "Sports"));
            categoryDAO.persist(new Category(2L, "Finance"));
            categoryDAO.persist(new Category(3L, "Movies"));

            userDAO.persist(new User(1L, "Marcos Neto", "marcosneto@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(2L, "Ana Silva", null, "489876", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(3L, "Carlos Souza", "carlos.souza@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(4L, "Fernanda Oliveira", "fernanda.oliveira@gmail.com", "489999", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.EMAIL))));
            userDAO.persist(new User(5L, "João Pedro", "joao.pedro@gmail.com", "489900", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL, Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(6L, "Maria Clara", "maria.clara@gmail.com", "489901", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(7L, "Lucas Almeida", "lucas.almeida@gmail.com", "489902", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(8L, "Juliana Costa", "juliana.costa@gmail.com", "489903", new ArrayList<>(Arrays.asList(new Category(1L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(9L, "Roberto Lima", "roberto.lima@gmail.com", "489904", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(10L, "Patrícia Sousa", "patricia.sousa@gmail.com", "489905", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(11L, "Eduardo Martins", "eduardo.martins@gmail.com", "489906", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(12L, "Tatiane Ribeiro", "tatiane.ribeiro@gmail.com", "489907", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(13L, "Felipe Fernandes", "felipe.fernandes@gmail.com", "489908", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(14L, "Camila Gomes", null, "489909", new ArrayList<>(Arrays.asList(new Category(1L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(15L, "Roberta Costa", "roberta.costa@gmail.com", "489910", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(16L, "Bruno Almeida", "bruno.almeida@gmail.com", "489911", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(17L, "Priscila Oliveira", "priscila.oliveira@gmail.com", "489912", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL, Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(18L, "Rafael Santos", "rafael.santos@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(19L, "Larissa Lima", "larissa.lima@gmail.com", "489914", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(20L, "Gustavo Martins", "gustavo.martins@gmail.com", "489915", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(21L, "Danielle Costa", "danielle.costa@gmail.com", "489916", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(22L, "Thiago Pereira", "thiago.pereira@gmail.com", "489917", new ArrayList<>(Arrays.asList(new Category(1L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(23L, "Marcela Santos", null, "489918", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(24L, "Felipe Costa", "felipe.costa@gmail.com", "489919", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(25L, "Larissa Almeida", "larissa.almeida@gmail.com", "489920", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL, Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(26L, "Victor Rodrigues", "victor.rodrigues@gmail.com", "489921", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(27L, "Isabela Silva", "isabela.silva@gmail.com", "489922", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(28L, "André Lima", "andre.lima@gmail.com", "489923", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(29L, "Sofia Oliveira", "sofia.oliveira@gmail.com", "489924", new ArrayList<>(Arrays.asList(new Category(1L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.EMAIL))));
            userDAO.persist(new User(30L, "Eduarda Gomes", "eduarda.gomes@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(31L, "Eduarda Gomes", "eduarda.gomes@gmail.com", "489925", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(32L, "João Pereira", "joao.pereira@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(33L, "Beatriz Lima", "beatriz.lima@gmail.com", "489927", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(34L, "Fernando Costa", "fernando.costa@gmail.com", "489928", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(35L, "Larissa Silva", "larissa.silva@gmail.com", "489929", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.EMAIL))));
            userDAO.persist(new User(36L, "Mateus Santos", "mateus.santos@gmail.com", "489930", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(37L, "Camila Oliveira", "camila.oliveira@gmail.com", "489931", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(38L, "Lucas Fernandes", null, "489932", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(39L, "Juliana Rocha", "juliana.rocha@gmail.com", "489933", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(40L, "Roberto Alves", "roberto.alves@gmail.com", "489934", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(41L, "Mariana Ribeiro", "mariana.ribeiro@gmail.com", "489935", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(42L, "Eduardo Gomes", "eduardo.gomes@gmail.com", "489936", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(43L, "Tatiane Silva", "tatiane.silva@gmail.com", "489937", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(44L, "Daniela Castro", "daniela.castro@gmail.com", "489938", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(45L, "Bruno Almeida", "bruno.almeida@gmail.com", "489939", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(46L, "Ana Clara", "ana.clara@gmail.com", "489940", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(47L, "Marcos Mendes", "marcos.mendes@gmail.com", "489941", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(48L, "Fernanda Martins", "fernanda.martins@gmail.com", "489942", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS, Channel.EMAIL))));
            userDAO.persist(new User(49L, "Lucas Costa", "lucas.costa@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(50L, "Juliana Almeida", "juliana.almeida@gmail.com", "489944", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(51L, "Daniel Silva", "daniel.silva@gmail.com", "489945", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(52L, "Tatiane Costa", "tatiane.costa@gmail.com", "489946", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(53L, "Eduardo Castro", "eduardo.castro@gmail.com", "489947", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(54L, "Gabriela Oliveira", "gabriela.oliveira@gmail.com", "489948", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(55L, "Paulo Lima", "paulo.lima@gmail.com", "489949", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(56L, "Renata Silva", "renata.silva@gmail.com", "489950", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(57L, "Vinícius Costa", "vinicius.costa@gmail.com", "489951", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(58L, "Carla Almeida", "carla.almeida@gmail.com", "489952", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(59L, "Eduardo Gomes", "eduardo.gomes2@gmail.com", "489953", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(60L, "Roberta Fernandes", "roberta.fernandes@gmail.com", null, new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(61L, "Leonardo Santos", "leonardo.santos@gmail.com", "489955", new ArrayList<>(Arrays.asList(new Category(3L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(62L, "Marcia Silva", "marcia.silva@gmail.com", "489956", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(63L, "Marcelo Rocha", "marcelo.rocha@gmail.com", "489957", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(64L, "Jéssica Martins", "jessica.martins@gmail.com", "489958", new ArrayList<>(Arrays.asList(new Category(1L), new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));
            userDAO.persist(new User(65L, "Paula Gomes", "paula.gomes@gmail.com", "489959", new ArrayList<>(Arrays.asList(new Category(2L), new Category(3L))), new ArrayList<>(Arrays.asList(Channel.EMAIL))));
            userDAO.persist(new User(66L, "Bruno Costa", "bruno.costa@gmail.com", "489960", new ArrayList<>(Arrays.asList(new Category(1L))), new ArrayList<>(Arrays.asList(Channel.SMS))));
            userDAO.persist(new User(67L, "Cintia Alves", "cintia.alves@gmail.com", "489961", new ArrayList<>(Arrays.asList(new Category(2L))), new ArrayList<>(Arrays.asList(Channel.PUSH_NOTIFICATION))));

        };
    }
}