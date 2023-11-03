package exemplul1;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MainApp {



    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Angajat> angajati=citire();

        for(Angajat p:angajati){
            System.out.println(p);
        }
//        LocalDate d1 = LocalDate.of(2017, Month.FEBRUARY, 12);
//        LocalDate d2 = LocalDate.of(2012, Month.FEBRUARY, 13);
//        LocalDate d3 = LocalDate.of(2012, Month.FEBRUARY, 14);
//        LocalDate d4 = LocalDate.of(2012, Month.FEBRUARY, 15);
//        LocalDate d5 = LocalDate.of(2012, Month.FEBRUARY, 16);
//
//        List<Angajat> angajati=new ArrayList<>();
//        angajati.add(new Angajat("Angajat 1","Programator",d1,5000));
//        angajati.add(new Angajat("Angajat 2","Programator2",d2,5000));
//        angajati.add(new Angajat("Angajat 3","Programator",d3,6000));
//        angajati.add(new Angajat("Angajat 4","Programator",d4,7000));
//        angajati.add(new Angajat("Angajat 5","Programator",d5,8000));
//        scriere(angajati);


        System.out.println("1-------");
        angajati.forEach(System.out::println);

        System.out.println("2-------");
        angajati.stream().filter(a->a.getSalariul()>100f).forEach(System.out::println);

        System.out.println("3-------");
        angajati.stream().filter(a->a.getData_angajarii().getYear()<2023).filter(a->a.getData_angajarii().);







    }

}