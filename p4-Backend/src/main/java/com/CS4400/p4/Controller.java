package com.CS4400.p4;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.objects.Procedures;
import com.objects.View1;
import com.objects.View2;
import com.objects.View3;
import com.objects.View4;
import com.objects.View5;
import com.objects.View6;
import com.objects.Views;

@CrossOrigin ("*")
@RestController
public class Controller {

	// Procedure Calls
	@RequestMapping(value = "/p1", method = RequestMethod.GET)
	public void p1(@RequestParam(value = "username", required = true) String username, 
	@RequestParam(value = "firstName", required = true) String firstName,
	@RequestParam(value = "lastName", required = true) String lastName,
	@RequestParam(value = "address", required = true) String address,
	@RequestParam(value = "birthdate", required = true) String birthdate) {
		// add_owner
		Procedures.procedure1(username, firstName, lastName, address, birthdate);
		System.out.println("done ... ran P1!");
	}

	@RequestMapping(value = "/p2", method = RequestMethod.GET)
	public void p2(@RequestParam(value = "username", required = true) String username,
	@RequestParam(value = "firstName", required = true) String firstName,
	@RequestParam(value = "lastName", required = true) String lastName,
	@RequestParam(value = "address", required = true) String address,
	@RequestParam(value = "birthdate", required = true) String birthdate,
	@RequestParam(value = "taxID", required = true) String taxID,
	@RequestParam(value = "hired", required = true) String hired,
	@RequestParam(value = "experience", required = true) Integer experience,
	@RequestParam(value = "salary", required = true) Integer salary) {
		// add_employee
		Procedures.procedure2(username, firstName, lastName, address, birthdate, taxID, hired, experience, salary);
		System.out.println("done ... ran P2!");
	}

	@RequestMapping(value = "/p3", method = RequestMethod.GET)
	public void p3(@RequestParam(value = "username", required = true) String license,
	@RequestParam(value = "licenseID", required = true) String licenseID,
	@RequestParam(value = "licenseType", required = true) String licenseType,
	@RequestParam(value = "experience", required = true) Integer experience) {
		// add_driver_role
		Procedures.procedure3(license, licenseID, licenseType, experience);
		System.out.println("done ... ran P3!");
	}

	@RequestMapping(value = "/p4", method = RequestMethod.GET)
	public void p4(@RequestParam(value = "username", required = true) String username) {
		// add_worker_role
		Procedures.procedure4(username);
		System.out.println("done ... ran P4!");
	}

	@RequestMapping(value = "/p5", method = RequestMethod.GET)
	public void p5(@RequestParam(value = "barcode", required = true) String barcode,
	@RequestParam(value = "name", required = true) String name,
	@RequestParam(value = "weight", required = true) Integer weight) {
		// add_product
		Procedures.procedure5(barcode, name, weight);
		System.out.println("done ... ran P5!");
	}

	@RequestMapping(value = "/p6", method = RequestMethod.GET)
	public void p6(@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag,
	@RequestParam(value = "fuel", required = true) Integer fuel,
	@RequestParam(value = "capacity", required = true) Integer capacity,
	@RequestParam(value = "sales", required = true) Integer sales,
	@RequestParam(value = "barcode", required = true) String driverBy) {
		// add_van
		Procedures.procedure6(id, tag, fuel, capacity, sales, driverBy);
		System.out.println("done ... ran P6!");
	}

	@RequestMapping(value = "/p7", method = RequestMethod.GET)
	public void p7(@RequestParam(value = "longName", required = true) String longName,
	@RequestParam(value = "rating", required = true) Integer rating,
	@RequestParam(value = "spent", required = true) Integer spent,
	@RequestParam(value = "location", required = true) String location) {
		// add_business
		Procedures.procedure7(longName, rating, spent, location);
		System.out.println("done ... ran P7!");
	}

	@RequestMapping(value = "/p8", method = RequestMethod.GET)
	public void p8(@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "longName", required = true) String longName,
	@RequestParam(value = "homeBase", required = true) String homeBase,
	@RequestParam(value = "manager") String manager) {
		// add_service
		if (manager.equals("")) {
			manager = null;
		}
		Procedures.procedure8(id, longName, homeBase, manager);
		System.out.println("done ... ran P8!");
	}
	
	@RequestMapping(value = "/p9", method = RequestMethod.GET)
	public void p9(@RequestParam(value = "label", required = true) String label,
	@RequestParam(value = "x", required = true) Integer x,
	@RequestParam(value = "y", required = true) Integer y,
	@RequestParam(value = "space") Integer space) {
		System.out.println(space);
		Procedures.procedure9(label, x, y, space);
		System.out.println("done ... ran P9!");
	}

	@RequestMapping(value = "/p11", method = RequestMethod.GET)
	public void p10(@RequestParam(value = "username", required = true) String username,
	@RequestParam(value = "id", required = true) String id) {
		// hire_employee
		Procedures.procedure11(username, id);
		System.out.println("done ... ran P11!");
	}

	@RequestMapping(value = "/p12", method = RequestMethod.GET)
	public void p11(@RequestParam(value = "username", required = true) String username,
	@RequestParam(value = "id", required = true) String id) {
		// fire_employee
		Procedures.procedure12(username, id);
		System.out.println("done ... ran P12!");
	}

	@RequestMapping(value = "/p10", method = RequestMethod.GET)
	public void p12(@RequestParam(value = "owner", required = true) String owner,
	@RequestParam(value = "amount", required = true) Integer amount,
	@RequestParam(value = "longName", required = true) String longName,
	@RequestParam(value = "fundDate", required = true) String fundDate) {
		// start_funding
		Procedures.procedure10(owner, amount, longName, fundDate);
		System.out.println("done ... ran P10!");
	}
	
	@RequestMapping(value = "/p13", method = RequestMethod.GET)
	public void p13(@RequestParam(value = "username", required = true) String username,
	@RequestParam(value = "id", required = true) String id) {
		// manage_service
		Procedures.procedure13(username, id);
		System.out.println("done ... ran P13!");
	}

	@RequestMapping(value = "/p14", method = RequestMethod.GET)
	public void p14(@RequestParam(value = "username", required = true) String username,
	@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag) {
		// takeover_van
		Procedures.procedure14(username, id, tag);
		System.out.println("done ... ran P14!");
	}

	@RequestMapping(value = "/p15", method = RequestMethod.GET)
	public void p15(@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag,
	@RequestParam(value = "barcode", required = true) String barcode,
	@RequestParam(value = "morePackages", required = true) Integer morePackages,
	@RequestParam(value = "price", required = true) Integer price) {
		// load_van
		Procedures.procedure15(id, tag, barcode, morePackages, price);
		System.out.println("done ... ran P15!");
	}

	@RequestMapping(value = "/p16", method = RequestMethod.GET)
	public void p16(@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag,
	@RequestParam(value = "moreFuel", required = true) Integer moreFuel) {
		// refuel_van
		Procedures.procedure16(id, tag, moreFuel);
		System.out.println("done ... ran P16!");
	}
	
	@RequestMapping(value = "/p17", method = RequestMethod.GET)
	public void p17(@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag,
	@RequestParam(value = "destination", required = true) String desination) {
		// drive_van
		Procedures.procedure17(id, tag, desination);
		System.out.println("done ... ran P17!");
	}

	@RequestMapping(value = "/p18", method = RequestMethod.GET)
	public void p18(@RequestParam(value = "longName", required = true) String longName,
	@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag,
	@RequestParam(value = "barcode", required = true) String barcode,
	@RequestParam(value = "quantity", required = true) Integer quantity) {
		// purchase_product
		Procedures.procedure18(longName, id, tag, barcode, quantity);
		System.out.println("done ... ran P18!");
	}

	@RequestMapping(value = "/p19", method = RequestMethod.GET)
	public void p19(@RequestParam(value = "barcode", required = true) String barcode) {
		// remove_product
		Procedures.procedure19(barcode);
		System.out.println("done ... ran P19!");
	}

	@RequestMapping(value = "/p20", method = RequestMethod.GET)
	public void p20(@RequestParam(value = "id", required = true) String id,
	@RequestParam(value = "tag", required = true) Integer tag) {
		// remove_van
		Procedures.procedure20(id, tag);
		System.out.println("done ... ran P20!");
	}
	
	@RequestMapping(value = "/p21", method = RequestMethod.GET)
	public void p21(@RequestParam(value = "username", required = true) String username) {
		// remove_driver_role
		Procedures.procedure21(username);
		System.out.println("done ... ran P21!");
	}
	// View calls
	@RequestMapping(value = "/v1", method = RequestMethod.GET)
	public List<View1> v1() {
		System.out.println("done ... ran V1!");
		return Views.runV1();
	}

	@RequestMapping(value = "/v2", method = RequestMethod.GET)
	public List<View2> v2() {
		System.out.println("done ... ran V2!");
		return Views.runV2();
	}

	@RequestMapping(value = "/v3", method = RequestMethod.GET)
	public List<View3> v3() {
		System.out.println("done ... ran V3!");
		return Views.runV3();
	}

	@RequestMapping(value = "/v4", method = RequestMethod.GET)
	public List<View4> v4() {
		System.out.println("done ... ran V4!");
		return Views.runV4();
	}

	@RequestMapping(value = "/v5", method = RequestMethod.GET)
	public List<View5> v5() {
		System.out.println("done ... ran V5!");
		return Views.runV5();
	}

	@RequestMapping(value = "/v6", method = RequestMethod.GET)
	public List<View6> v6() {
		System.out.println("done ... ran V6!");
		return Views.runV6();
	}
}