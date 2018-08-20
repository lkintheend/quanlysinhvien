package quanly.restfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

import quanly.sinhvien.service.MonHocServiceImp;

@SpringBootApplication
@ComponentScan({"quanly.sinhvien","quanly.restfull"})
public class QuanlysinhvienRestfullApplication implements CommandLineRunner{
	@Autowired
	MonHocServiceImp monHocServiceImp;
	public static void main(String[] args) {
		SpringApplication.run(QuanlysinhvienRestfullApplication.class, args);
	}

	@Override
	@JsonIgnore
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(monHocServiceImp.findAll());
	}
}
