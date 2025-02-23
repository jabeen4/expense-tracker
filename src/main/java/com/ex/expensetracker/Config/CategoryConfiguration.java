package com.ex.expensetracker.Config;

import com.ex.expensetracker.Repository.CategoryRepository;
import com.ex.expensetracker.model.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerCategories(CategoryRepository categoryRepository) {
        return args -> {
            if (categoryRepository.count() == 0) {
                List<Category> defaultCategories = List.of(
                        new Category(null, "others", "Default category"),
                        new Category(null, "groceries", "You can add groceries here"),
                        new Category(null, "travel", "You can add travel here"),
                        new Category(null, "concerts", "You can add concerts here"),
                        new Category(null, "cinema", "You can add cinema here"),
                        new Category(null, "fitness", "You can add fitness here")
                );

                categoryRepository.saveAll(defaultCategories);
            }
        };
    }
}
