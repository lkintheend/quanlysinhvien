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

import quanly.sinhvien.model.SinhVien;
import quanly.sinhvien.service.SinhVienService;

@RestController
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;

	@RequestMapping(value = "/sinhviens", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<SinhVien> getSinhViens() {
		List<SinhVien> list = sinhVienService.findAll();
		return list;
	}

	@RequestMapping(value = "/sinhvien/{sinhvienid}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public SinhVien getSinhVien(@PathVariable("sinhvienid") int sinhVienId) {
		return sinhVienService.getOne(sinhVienId);
	}

	@RequestMapping(value = "/sinhvien", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public SinhVien addSinhVien(@RequestBody SinhVien monHoc) {
		sinhVienService.save(monHoc);
		return sinhVienService.getOne(monHoc.getSinhVienId());
	}

	@RequestMapping(value = "/sinhvien", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public SinhVien updateSinhVien(@RequestBody SinhVien sinhVien) {
		sinhVienService.update(sinhVien);
		return sinhVienService.getOne(sinhVien.getSinhVienId());
	}

	@RequestMapping(value = "/sinhvien/{sinhvienid}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void deleteSinhVien(@PathVariable("sinhvienid") int sinhvienid) {

		System.out.println("(Service Side) Deleting employee: " + sinhvienid);

		sinhVienService.delete(sinhvienid);
	}
}
