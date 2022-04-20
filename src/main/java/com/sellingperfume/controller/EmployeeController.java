package com.sellingperfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sellingperfume.entity.EmployeesEntity;
import com.sellingperfume.entity.ProductEntity;
import com.sellingperfume.entity.ProductTypeEntity;
import com.sellingperfume.services.impl.EmployServiceImplements;
import com.sellingperfume.services.impl.MediaServiceImplements;
import com.sellingperfume.services.impl.ProductServiceImplements;
import com.sellingperfume.services.impl.ProductTypeServiceImplements;

@RestController
@RequestMapping("/admin")
public class EmployeeController {
	@Value("${upload.path}")
	private String uploadPath;
	@Autowired
	public EmployServiceImplements employServiceImplements;
	@Autowired
	public ProductTypeServiceImplements productTypeServiceImplements;
	@Autowired
	public ProductServiceImplements productServiceImplements;
	@Autowired
	public MediaServiceImplements mediaServiceImplements;

	@GetMapping(path = "/employees")
	public List<?> EmployeesChart() {
		List<EmployeesEntity> listEmployees = employServiceImplements.GetAllUser();
		return listEmployees;
	}

	@GetMapping(path = "/chart")
	public ModelAndView charts(Model model) {
		ModelAndView mView = new ModelAndView("templates/chart");
		List<EmployeesEntity> listEmployees = employServiceImplements.GetAllUser();
		model.addAttribute("listEmployees", listEmployees);
		return mView;
	}

	@GetMapping(path = "/viewcreatetypeproduct")
	public ModelAndView ViewAddProductType(Model model) {
		ProductTypeEntity productTypeEntity = new ProductTypeEntity();
		model.addAttribute("productType", productTypeEntity);
		ModelAndView mView = new ModelAndView("templates/AddProductType");
		return mView;
	}

	@PostMapping(path = "/createproducttype")
	public ProductTypeEntity AddProductType(@ModelAttribute("productType") ProductTypeEntity productTypeEntity) {
		return productTypeServiceImplements.CreateProductType(productTypeEntity);
	}

	@GetMapping(path = "/viewcreateproduct")
	public ModelAndView ViewCreateProduct(Model model) {
		ProductEntity productEntity = new ProductEntity();
		model.addAttribute("products", productEntity);
		model.addAttribute("listProductType", productTypeServiceImplements.ListFindAllTypeProduct());
		ModelAndView mView = new ModelAndView("templates/AddProduct");
		return mView;
	}

	@PostMapping(path = "/createproduct")
	public ProductEntity CreateProduct(@ModelAttribute("products") ProductEntity productEntity,
			@RequestParam("file") MultipartFile file) {
		String uploadPaths = uploadPath + "/products";
		int checkupload = mediaServiceImplements.UploadFile(uploadPaths, file);

		productEntity.setAvatar(file.getOriginalFilename());

		return productServiceImplements.CreatePrduct(productEntity);
	}
}
