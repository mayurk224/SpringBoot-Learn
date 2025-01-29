package com.springbootproject.todo.service.impl;

import com.springbootproject.todo.dto.TodoDto;
import com.springbootproject.todo.entity.Todo;
import com.springbootproject.todo.exception.ResourceNotFoundException;
import com.springbootproject.todo.repository.TodoRepository;
import com.springbootproject.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto,Todo.class);

        Todo saveTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(saveTodo,TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id: "+id)
        );

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map(
                (todo)-> modelMapper.map(todo, TodoDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id: "+id)
        );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id: "+id)
        );
        todoRepository.deleteById(id);

    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id: "+id)
        );
        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo,TodoDto.class);
    }
}
