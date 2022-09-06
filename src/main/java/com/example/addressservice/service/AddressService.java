package com.example.addressservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.addressservice.dto.AddressResponse;
import com.example.addressservice.dto.CreateAddressRequest;
import com.example.addressservice.entity.Address;
import com.example.addressservice.repository.AddressRepository;

@Component
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		Address address = new Address(createAddressRequest.getStreet(), createAddressRequest.getCity());
		return getResponse(addressRepository.save(address));
	}
	
	public AddressResponse getAddressById(long addressId) {
		return getResponse(addressRepository.getReferenceById(addressId));
	}
	
	private AddressResponse getResponse(Address savedAddress) {
		AddressResponse response = new AddressResponse();
		response.setAddressId(savedAddress.getId());
		response.setCity(savedAddress.getCity());
		response.setStreet(savedAddress.getStreet());
		return response;
	}
}
