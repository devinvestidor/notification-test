package br.com.devinvestidor.notification.controller;

import br.com.devinvestidor.notification.response.Response;
import br.com.devinvestidor.notification.service.CategoryService;
import br.com.devinvestidor.notification.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends Controller {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Response listAll() {
        return okList(categoryService.listAll());
    }

}