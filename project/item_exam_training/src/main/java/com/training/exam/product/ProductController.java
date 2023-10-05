package com.training.exam.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
   
   private final ProductService productService;

   @GetMapping("/list")
   public String listPage(Model model){
      model.addAttribute("productList", productService.productList());
      return "product/productList";
   }

   @GetMapping("/{productId}")
   public String detailPage(@PathVariable Long productId, Model model) {
      model.addAttribute("product", productService.getProductById(productId));
      return "product/productDetail";
   }

   @GetMapping("/add")
   public String addPage(@ModelAttribute Product product){
      return "product/productAdd";
   }

   @PostMapping("/add")
   public String add(
         @ModelAttribute Product product, 
         RedirectAttributes redirectAttributes){
      productService.addProduct(product);
      redirectAttributes.addAttribute("status", "add");
      return "redirect:/product/" + product.getId();
   }

   @GetMapping("/edit/{productId}")
   public String editPage(@PathVariable Long productId, Model model) {
      model.addAttribute("product", productService.getProductById(productId));
      return "product/productEdit";
   }

   @PostMapping("/edit/{productId}")
   public String edit(
         @PathVariable Long productId, 
         @ModelAttribute Product product,
         RedirectAttributes redirectAttributes) {
      productService.editProduct(productId, product);
      redirectAttributes.addAttribute("status", "edit");
      return "redirect:/product/" + productId;
   }
}
