package com.moaddi.ui.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;


import com.moaddi.dao.CustomerDAO;
import com.moaddi.dao.model.CustomerTL;
import com.moaddi.service.CustomerService;
import com.moaddi.service.dto.CustomerDTO;
import com.moaddi.ui.forms.CustomerRegistrationForm;


@Controller



@RequestMapping("/showbasic")

public class CustomerRegistrationFormController  {
	
	
		
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("reg") CustomerRegistrationForm customerRegistrationForm,
			BindingResult result, SessionStatus status) {
			CustomerDTO customerDTO=new CustomerDTO();
			//customerDTO.setAnswer(customerRegistrationForm.getAns());
			//customerDTO.setCountry(customerRegistrationForm.getCountry());
			customerDTO.setPassword(customerDTO.getPassword());
			/*if(customerRegistrationForm.getDay()!=null && !customerRegistrationForm.getDay().trim().equals("")&&   customerRegistrationForm.getMonth()!=null && !customerRegistrationForm.getMonth().trim().equals("")&&customerRegistrationForm.getYear()!=null&& !customerRegistrationForm.getYear().trim().equals("") )
			{
				
				try {
					SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
					Date dateOfBirth=sdf.parse(customerRegistrationForm.getDay()+"-"+customerRegistrationForm.getMonth()+"-"+customerRegistrationForm.getYear());
					customerDTO.setDateOfBirth(new java.sql.Date(dateOfBirth.getTime()));
					customerDTO.setDobType(customerRegistrationForm.getDob());
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}*/
			customerDTO.setEmail(customerRegistrationForm.getEmail());
			customerDTO.setFullName(customerRegistrationForm.getFullName());
			//customerDTO.setGender(customerRegistrationForm.getGender());
			//customerDTO.setIdKind(customerRegistrationForm.getIdProofId());
			//ustomerDTO.setIdProofFileName(customerRegistrationForm.getIdProofFileName());
			customerDTO.setMobileNo(customerRegistrationForm.getMobileNo());
			//customerDTO.setNationality(customerRegistrationForm.getNationality());
			customerDTO.setPassword(customerRegistrationForm.getPassword());
			//customerDTO.setSecretQuestion(customerRegistrationForm.getSecretQId());
			//customerDTO.setCountryCode(customerRegistrationForm.getTxtm());
			customerDTO.setUserId(customerRegistrationForm.getUserId().toUpperCase());
			//customerDTO.setRegistrationType(customerRegistrationForm.getRegistrationType());
			customerDTO.setCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
		//	customerDTO.setCity(customerRegistrationForm.getCity());
			customerDTO.setStatus("Active");
			
			String returnForm="";
			
			Long customerId=customerService.saveCustomer(customerDTO);
			System.out.println("cust id"+ customerId);
			if(customerId!=null)
			{
				
					
						returnForm="redirect:basicsuccess.htm?uid="+customerDTO.getUserId();
					
						
					
				
			}
			
			
			return returnForm;
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showReg() {
		
		return "showbasic.page";
		
		
	}
	

	
	
	
}

	


