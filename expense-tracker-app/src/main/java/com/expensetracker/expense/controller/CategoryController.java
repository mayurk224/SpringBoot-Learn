package com.expensetracker.expense.controller;

import com.expensetracker.expense.dto.CategoryDto;
import com.expensetracker.expense.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId){
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getALlCategories(){
        List<CategoryDto> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long categoryId,@RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = categoryService.updateCategory(categoryId,categoryDto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted Succesffully");
    }
}
