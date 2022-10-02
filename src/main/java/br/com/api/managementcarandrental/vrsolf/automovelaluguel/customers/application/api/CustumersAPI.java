package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public interface CustumersAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CustomersResponse postCustomers(@Valid @RequestBody CustomersRequest customersRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<CustomersListResponse> getTodosCustomers();
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	CustomersDetalhadoResponse getCustomersAtravesId(@PathVariable UUID id);
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaCustomerseAtravesId(@PathVariable UUID id);
	
	@PatchMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraCustomers(@PathVariable UUID id,
			@Valid @RequestBody CustomersAlteracaoRequest custumersAlteracaoRequest);
}