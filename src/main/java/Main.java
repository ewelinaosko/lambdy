import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

// Napisz przypisując do zmiennej typu Consumer<T> lambdę:
// •Drukującą podany argument (T = String)
        Consumer<String> consumer1 = x ->System.out.println(x);
        consumer1.accept("Argument1");

// •Dodającą argument do jakiejś listy (T = String)
        List<String> list = new ArrayList<>();
        list.add("InitialElement");
        list.add("SecondElement");
        Consumer<String> consumer2 = x ->list.add(x);
        consumer2.accept("Argument2");
        list.forEach(System.out::println);

// •Drukującą kwadrat liczby (T = Long)
        Consumer<Long> consumer3 = x -> System.out.println(x*x);
        consumer3.accept(123L);


// Napisz przypisując do zmiennej typu Function<T, R> lambdę:
//  •Przekształcającą tekst w formacie „ImięNazwisko;Wiek” w obiekt typu Człowiek o polach imię, wiek (T=String, R=Człowiek)
        Function<String, Czlowiek> function1 = x -> new Czlowiek(x);
        System.out.println(function1.apply("Ewelina;Osko").getImie());
        System.out.println(function1.apply("Ewelina;Osko").getWiek());

//  •Przekształcającą datę typu LocalDate w obiekt typu LocalDateTime wskazujący na tą datę w południe (T=LocalDate, R=LocalDateTime)
        Function<LocalDate, LocalDateTime> function2 = x -> x.atStartOfDay().plusHours(12L);
        LocalDate date = LocalDate.now();
        System.out.println(function2.apply(date));

// Napisz przypisując do zmiennej typu Predicate<T> lambdę:
//  •Sprawdzającą, czy podany tekst zawiera cyfry (T=String)

        Predicate<String> pattern1 = Pattern.compile("\\d").asPredicate();
        Predicate<String> predicate1 = x -> pattern1.test(x);
        System.out.println(predicate1.test("IHHuu^%5QQ"));
        System.out.println(predicate1.test("IHHuu^%QQ"));
        System.out.println(predicate1.test("0IHHuu^%QQ"));

//  •Sprawdzającą, czy podany tekst zawiera na początku lub na końcu białe znaki
        Predicate<String> pattern2 = Pattern.compile("(\\s\\w\\s)|(\\w\\s)|(\\s\\w)").asPredicate();
        Predicate<String> predicate2 = x -> pattern2.test(x);
        System.out.println(predicate2.test(" IHHuu^%5QQ"));
        System.out.println(predicate2.test("IHHuu^%QQ    "));
        System.out.println(predicate2.test(" IHHuu^%QQ "));
        System.out.println(predicate2.test("IHHuu^%QQ"));
//  •Sprawdzającą, czy podana liczba jest podzielna przez 3 oraz 5.
        Predicate<Double> predicate3 = x -> x%3==0 && x%5==0;
        System.out.println(predicate3.test(123D));
        System.out.println(predicate3.test(150D));
    }
}

/*
Zadanie 1. Lambdy

Napisz przypisując do zmiennej typu Consumer<T> lambdę:
•Drukującą podany argument (T = String)
•Dodającą argument do jakiejś listy (T = String)
•Drukującą kwadrat liczby (T = Long)

Napisz przypisując do zmiennej typu Function<T, R> lambdę:
•Przekształcającą tekst w formacie „ImięNazwisko;Wiek” w obiekt typu Człowiek o polach imię, wiek (T=String, R=Człowiek)
•Przekształcającą datę typu LocalDate w obiekt typu LocalDateTime wskazujący na tą datę w południe (T=LocalDate, R=LocalDateTime)

Napisz przypisując do zmiennej typu Predicate<T> lambdę:
•Sprawdzającą, czy podany tekst zawiera cyfry (T=String)
•Sprawdzającą, czy podany tekst zawiera na początku lub na końcu białe znaki
•Sprawdzającą, czy podana liczba jest podzielna przez 3 oraz 5.

 */
