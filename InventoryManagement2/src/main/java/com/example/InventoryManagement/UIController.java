package com.example.InventoryManagement;

import java.util.List;

import javax.management.AttributeNotFoundException;
import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.InventoryManagement.entity.Customer;
import com.example.InventoryManagement.entity.Invoice;
import com.example.InventoryManagement.entity.Product;
import com.example.InventoryManagement.entity.Supplier;
import com.example.InventoryManagement.service.CustomerService;
import com.example.InventoryManagement.service.InvoiceService;
import com.example.InventoryManagement.service.ProductService;
import com.example.InventoryManagement.service.SupplierService;



@Controller
public class UIController {
	
	private ProductService productService;
	private SupplierService supplierService;
	private InvoiceService invoiceService;
	private CustomerService customerService;
	
	
	
@Autowired	
public UIController(ProductService productService, SupplierService supplierService,
			InvoiceService invoiceService,CustomerService customerService) {
		super();
		this.productService = productService;
		this.supplierService = supplierService;
		this.invoiceService = invoiceService;
		this.customerService = customerService;
		
	}

//@GetMapping("/")
	
	//String index() {
		//return "index";/// index.html
	//}

// Employee 
@GetMapping("/registration")
public String proRegistrationForm(Model model) {
	Product product = new Product();
	model.addAttribute("product", product);
    return "add-product";
}

@PostMapping("/saveProduct")
public String saveProduct(@Valid  Product product, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    productService.saveProduct(product);
	List<Product> products =  productService.getAllProduct();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getProducts";
    
}

@GetMapping("/getProducts")
public String getAllProduct(Model model) {
	
	List<Product> products =  productService.getAllProduct();
	
	model.addAttribute("products", products);
	
    return "list-product";}
@GetMapping("/updateFormProduct/{id}")
public String updateFormProduct(@PathVariable(value="id") long id,Model model)
{
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
	return "update-product";
}
@GetMapping("/deleteProduct/{id}")
public String deleteProduct(@PathVariable  long id)
{
	productService.deleteProductById(id);
	return "redirect:/";
}



// Supplier

@GetMapping("/Supplierregistration")
public String supRegistrationForm(Model model) {
	Supplier supplier = new Supplier();
	model.addAttribute("supplier", supplier);
    return "add-supplier";
}

@PostMapping("/saveSupplier")
public String saveSupplier(@Valid  Supplier supplier, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    supplierService.saveSupplier(supplier);
	List<Supplier> suppliers =  supplierService.getAllSupplier();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getSuppliers";
    
}

@GetMapping("/getSuppliers")
public String getAllSupplier(Model model) {
	
	List<Supplier> suppliers =  supplierService.getAllSupplier();
	
	model.addAttribute("suppliers", suppliers);
	
    return "list-supplier";}



@GetMapping("/updateFormSupplier/{id}")
public String updateFormSupplier(@PathVariable(value="id") long id,Model model)
{
	Supplier supplier=supplierService.getSupplierById(id);
	model.addAttribute("supplier",supplier);
	return "update-supplier";
}

@GetMapping("/deleteSupplier/{id}")
public String deleteSupplier(@PathVariable  long id)
{
	supplierService.deleteSupplierById(id);
	return "redirect:/login";
}


//Invoice

@GetMapping("/Invoiceregistration")
public String invRegistrationForm(Model model) {
	Invoice invoice = new Invoice();
	model.addAttribute("invoice", invoice);
    return "add-invoice";
}

@PostMapping("/saveInvoice")
public String saveInvoice(@Valid  Invoice invoice, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    invoiceService.saveInvoice(invoice);
	List<Invoice> invoices =  invoiceService.getAllInvoice();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getInvoices";
    
}

@GetMapping("/getInvoices")
public String getAllInvoice(Model model) {
	
	List<Invoice> invoices =  invoiceService.getAllInvoice();
	
	model.addAttribute("invoices", invoices);
	
    return "list-invoice";}

@GetMapping("/updateFormInvoice/{id}")
public String updateFormInvoice(@PathVariable(value="id") long id,Model model)
{
	Invoice invoice=invoiceService.getInvoiceById(id);
	model.addAttribute("invoice",invoice);
	return "update-invoice";
}
//customer
@GetMapping("/Customerregistration")
public String cusRegistrationForm(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);
    return "add-customer";
}
@GetMapping("/Registration")
public String customerRegistrationForm(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);
    return "Registration";
}
/*@GetMapping("/register-success")
public String processRegistrationForm(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);
    return "register-success";
}*/

@PostMapping("/saveCustomer")
public String saveCustomer(@Valid  Customer customer, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    customerService.saveCustomer(customer);
    List<Customer> customers =  customerService.getAllCustomer();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/login";
    
}

@GetMapping("/getCustomers")
public String getAllCustomer(Model model) {
	
	List<Customer> customers =  customerService.getAllCustomer();
	
	model.addAttribute("customers", customers);
	
    return "list-customer";}

@GetMapping("/updateFormCustomer/{id}")
public String updateFormCustomer(@PathVariable(value="id") long id,Model model)
{
	Customer customer=customerService.getCustomerById(id);
	model.addAttribute("customer",customer);
	return "update-customer";
}

}


