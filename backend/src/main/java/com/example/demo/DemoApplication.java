package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ManuRepository manuRepository,
						   CoffeeTypeRepository coffeetypeRepository,
						   BakeryTypeRepository bakerytypeRepository,
						   ManuTypeRepository manutypeRepository,
						   ProvinceRepository provinceRepository,
						   NametypeRepository nametypeRepository,
						   GenderRepository genderRepository,
						   MemberRepository memberRepository,
						   PaymentRepository paymentRepository,
						   OrderTypeRepository orderTypeRepository,
						   CoffeeMenuRepository coffeeMenuRepository,
						   CoffeeOrderRepository coffeeOrderRepository,
						   CustomerRepository customerRepository,
						   StaffRepository staffRepository,
						   AddpointRepository addpointRepository,
						   ServiceTypeRepository serviceTypeRepository,
 RewardRepository rewardRepository,
						   TyperewardRepository typerewardRepository

						   ) {
		return args -> {

			Stream.of("-","ร้อน","เย็น","ปั่น").forEach(coffee ->{
				CoffeeType coffeetype = new CoffeeType();
				coffeetype.setCoffee(coffee);
				coffeetypeRepository.save(coffeetype);
			});
			coffeetypeRepository.findAll().forEach(System.out::println);
			Stream.of("-","SANWICH","CAKE&ROLL","MUFFIN").forEach(bakery ->{
				BakeryType bakerytype = new BakeryType();
				bakerytype.setBakery(bakery);
				bakerytypeRepository.save(bakerytype);
			});
			bakerytypeRepository.findAll().forEach(System.out::println);
			Stream.of("Coffee","Bakery").forEach(menu -> {
				ManuType manutype = new ManuType();
				manutype.setManut(menu);
				manutypeRepository.save(manutype);
			});
			manutypeRepository.findAll().forEach(System.out::println);

			Manu manu = new Manu();
			manu.setName("ลาเต้");
			manu.setPrice(40);
			manu.setManutype(manutypeRepository.getOne(1L));
			manu.setCoffeetype(coffeetypeRepository.getOne(2L));
			manu.setBakerytype(bakerytypeRepository.getOne(1L));
			manuRepository.save(manu);

			Manu manu2 = new Manu();
			manu2.setName("มอลค่า");
			manu2.setPrice(45);
			manu2.setManutype(manutypeRepository.getOne(1L));
			manu2.setCoffeetype(coffeetypeRepository.getOne(2L));
			manu2.setBakerytype(bakerytypeRepository.getOne(1L));
			manuRepository.save(manu2);

			Manu manu3 = new Manu();
			manu3.setName("ชาเขียว");
			manu3.setPrice(49);
			manu3.setManutype(manutypeRepository.getOne(1L));
			manu3.setCoffeetype(coffeetypeRepository.getOne(2L));
			manu3.setBakerytype(bakerytypeRepository.getOne(1L));
			manuRepository.save(manu3);
//===========================================fon===============================================
			Stream.of("นาย","นาง","นางสาว","อื่นๆ").forEach(typename ->{
				Nametype nametype = new Nametype();
				nametype.setNameDoc(typename);
				nametypeRepository.save(nametype);
			});
			Stream.of("ชาย","หญิง").forEach(sex ->{
				Gender gender = new Gender();
				gender.setGender(sex);
				genderRepository.save(gender);
			});
			Stream.of("กระบี่","กรุงเทพฯ","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี",
					"ชัยนาท","ชัยภูมิ","ชุมพร","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา",
					"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์",
					"ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา","พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","ภูเก็ต","มหาสารคาม"
					,"มุกดาหาร","ยะลา","ยโสธร","ระนอง","ระยอง","ราชบุรี","ร้อยเอ็ด","ลพบุรี","ลำปาง","ลำพูน","ศรีสะเกษ"
					,"สกลนคร","สงขลา","สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระบุรี","สระแก้ว","สิงห์บุรี","สุพรรณบุรี"
					,"สุราษฎร์ธานี","สุรินทร์","สุโขทัย","หนองคาย","หนองบัวลำภู","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี"
					,"อ่างทอง","เชียงราย","เชียงใหม่","เพชรบุรี","เพชรบูรณ์","เลย","แพร่","แม่ฮ่องสอน").forEach(p -> {
				Province province = new Province();
				province.setNamePa(p);
				provinceRepository.save(province);
			});

			Member member= new Member();
			member.setNameM("ลิซ่า มาเร็ว");
			member.setN(nametypeRepository.getOne(3L));
			member.setG(genderRepository.getOne(2L));
			member.setP(provinceRepository.getOne(2L));
			member.setAddress("45/54");
			member.setUser("1np");
			member.setPassword("12345");
			memberRepository.save(member);

//===========================================Pek===============================================

			Staff staff1 = new Staff("Nuntawut Hahara");
			Staff staff2 = new Staff(":onado Kolamthong");
			Staff staff3 = new Staff("Mahanaree Mehrokaw");
			Staff staff4 = new Staff("Renawa thonglam");
			Staff staff5 = new Staff("Apisit Prompha");
			Staff staff6 = new Staff("Yamaha Infinity");
			Staff staff7 = new Staff("Honda Eiheedang");
			staff1.setUsername("Momo");
			staff1.setPassword("1234");
			staffRepository.save(staff1);
			staffRepository.save(staff2);
			staffRepository.save(staff3);
			staffRepository.save(staff4);
			staffRepository.save(staff5);
			staffRepository.save(staff6);
			staffRepository.save(staff7);

			Customer customer1 = new Customer("Catariya Eiei");
			Customer customer2 = new Customer("Apichat Chaiyawong");
			Customer customer3 = new Customer("Nuntawut Manathong");
			Customer customer4 = new Customer("Chanwit Eieiminoru");
			Customer customer5 = new Customer("Wichai Eieiminathonglam");
			Customer customer6 = new Customer("Kanyara Jumpahom");
			Customer customer7 = new Customer("Kongtahong Menawun");
			Customer customer8 = new Customer("Pake Heenamung");
			Customer customer9 = new Customer("Senamani Meeraimai");
			Customer customer10 = new Customer("Phomkrak Nawusa");
			customerRepository.save(customer1);
			customerRepository.save(customer2);
			customerRepository.save(customer3);
			customerRepository.save(customer4);
			customerRepository.save(customer5);
			customerRepository.save(customer6);
			customerRepository.save(customer7);
			customerRepository.save(customer8);
			customerRepository.save(customer9);
			customerRepository.save(customer10);

			CoffeeMenu coffeeMenu1 = new CoffeeMenu("Capushino");
			CoffeeMenu coffeeMenu2 = new CoffeeMenu("Black Coffee");
			CoffeeMenu coffeeMenu3 = new CoffeeMenu("Late");
			coffeeMenuRepository.save(coffeeMenu1);
			coffeeMenuRepository.save(coffeeMenu2);
			coffeeMenuRepository.save(coffeeMenu3);

			OrderType orderType1 = new OrderType("Dine-In");
			OrderType orderType2 = new OrderType("Take-Away");
			orderTypeRepository.save(orderType1);
			orderTypeRepository.save(orderType2);
			

			Addpoint addpoint1 = new Addpoint("1");
			Addpoint addpoint2 = new Addpoint("2");
			Addpoint addpoint3 = new Addpoint("3");
			Addpoint addpoint4 = new Addpoint("4");
			Addpoint addpoint5 = new Addpoint("5");
			addpointRepository.save(addpoint1);
			addpointRepository.save(addpoint2);
			addpointRepository.save(addpoint3);
			addpointRepository.save(addpoint4);
			addpointRepository.save(addpoint5);

			Typereward typereward1 = new Typereward("SuperSpecial");
			Typereward typereward2 = new Typereward("Special");
			Typereward typereward3 = new Typereward("Normal");
			Typereward typereward4 = new Typereward("-");
			typerewardRepository.save(typereward1);
			typerewardRepository.save(typereward2);
			typerewardRepository.save(typereward3);
			typerewardRepository.save(typereward4);

			Stream.of("Delivery", "Takeaway").forEach(typeName-> {

				{
					ServiceType serviceType = new ServiceType();
					serviceType.setService(typeName);
					serviceTypeRepository.save(serviceType);

				}
			});
		};
	}
}
