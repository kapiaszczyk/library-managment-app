package dev.kapiaszczyk.bookstore.library.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findByNameIgnoreCase(String categoryName) {
        return categoryRepository.findByNameIgnoreCase(categoryName);
    }

    public List<CategoryStatisticsDTO> getAllCategoriesBookCountStatistics() {
        List<Object[]> results = categoryRepository.getAllCategoriesStatistics();
        return CategoryMapper.mapToDTOList(results);
    }

}
