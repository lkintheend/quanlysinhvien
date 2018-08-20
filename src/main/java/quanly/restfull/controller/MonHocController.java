package quanly.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quanly.sinhvien.model.MonHoc;
import quanly.sinhvien.service.MonHocService;

@RestController
public class MonHocController {
	@Autowired
	MonHocService monHocService;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value = "/monhocs", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<MonHoc> getMonHocs() {
		List<MonHoc> list = monHocService.findAll();
		return list;
	}

	@RequestMapping(value = "/monhoc/{monHocId}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public MonHoc getMonHoc(@PathVariable("monHocId") int monHocId) {
		return monHocService.getOne(monHocId);
	}

	@RequestMapping(value = "/monhoc", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public MonHoc addMonHoc(@RequestBody MonHoc monHoc) {
		monHocService.save(monHoc);
		return monHocService.getOne(monHoc.getMonHocId());
	}

	@RequestMapping(value = "/monhoc", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public MonHoc updateMonHoc(@RequestBody MonHoc monHoc) {
		monHocService.update(monHoc);
		return monHocService.getOne(monHoc.getMonHocId());
	}

	@RequestMapping(value = "/monhoc/{monHocId}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void deleteMonHoc(@PathVariable("monHocId") int monHocId) {

		System.out.println("(Service Side) Deleting employee: " + monHocId);

		monHocService.delete(monHocId);
	}
}
