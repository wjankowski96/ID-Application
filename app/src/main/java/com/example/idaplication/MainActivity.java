package com.example.idaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btn;
    TextView tvResult;
    TextView tvResult2;
    TextView tvResult3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btn = findViewById(R.id.btn);
        tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);



/**
 * Programowanie klawisza "zatwierdz"
 */
        btn.setOnClickListener(view -> {
            String idNumber = etID.getText().toString().trim();
            String yearOfBirth = idNumber.substring(0, 2);
            String monthOfBirth = idNumber.substring(2, 4);
            String dayOfBirth = idNumber.substring(4, 6);
            int gender = Integer.parseInt(Character.toString(idNumber.charAt(9)));
            String sGender;
            int lKontrolna = Integer.parseInt(Character.toString(idNumber.charAt(10)));


/**
 * Zamiana wpisywanych liczb ze Stringów na Inty
 */
            int number1 = Integer.parseInt(Character.toString(idNumber.charAt(0)));
            int number2 = Integer.parseInt(Character.toString(idNumber.charAt(1)));
            int number3= Integer.parseInt(Character.toString(idNumber.charAt(2)));
            int number4 = Integer.parseInt(Character.toString(idNumber.charAt(3)));
            int number5 = Integer.parseInt(Character.toString(idNumber.charAt(4)));
            int number6 = Integer.parseInt(Character.toString(idNumber.charAt(5)));
            int number7 = Integer.parseInt(Character.toString(idNumber.charAt(6)));
            int number8 = Integer.parseInt(Character.toString(idNumber.charAt(7)));
            int number9 = Integer.parseInt(Character.toString(idNumber.charAt(8)));
            int number10 = Integer.parseInt(Character.toString(idNumber.charAt(9)));

/**
 * Obliczanie liczby kontrolnej
 */

            int liczbaKontrolna=0;

            number2=number2*3;
            number3=number3*7;
            number4=number4*9;
            number6=number6*3;
            number7=number7*7;
            number8=number8*9;
            number10=number10*3;

            if(number2 >9)
                number2 = number2 % 10;
            if(number3 >9)
                number3 = number3 % 10;
            if(number4 >9)
                number4 = number4 % 10;
            if(number6 >9)
                number6 = number6 % 10;
            if(number7 >9)
                number7 = number7 % 10;
            if(number9 >9)
                number9 = number9 % 10;
            if(number10 >9)
                number10 = number10 % 10;

            int suma=0;
            suma = number1+number2+number3+number4+number5+number6+number7+number8+number9+number10;

            if (suma>9)
                suma=suma % 10;
            int liczba_kontrolna_koncowa = 0;
            liczba_kontrolna_koncowa = 10 - suma;
            String lkk = String.valueOf(liczba_kontrolna_koncowa);
            String text1= "\n\nLiczba kontrolna powinna wynosic: " + lkk +
                    ".\n Jest obliczana jest ze wzoru dostepnego jak na stronie:  ";
            String  text2 = "Nieprawidlowy numer kontrolny";
            String adres = "https://www.gov.pl/web/gov/czym-jest-numer-pesel#";
            if (liczba_kontrolna_koncowa == lKontrolna)
                {tvResult2.setText(text1);
                    tvResult3.setVisibility(View.VISIBLE);
                tvResult3.setText(adres);}
            else {
                tvResult2.setText(text2);
                tvResult3.setVisibility(View.GONE);
            }



/**
* Sprawdzanie płci osoby
*/
            if (gender % 2 == 0) {
                sGender = "Kobieta";
            } else
                sGender = "Mężczyzna";


/**
 * W dowodach wydanych po 2000 roku zdarza się, że liczby reprezentujace miesiac
 * (np styczen, luty, marzec, ...) zpisywane sa w postaci styczeń=21, luty=22, marzec=23
 * Tutaj ustalamy czy miesiac jest wiekszy od 12 i jesli jest, to przypisujemy mu tylko
 * jedną liczbę, jesli wszystko sie zgadza zostawiamy dwucyfrowa liczbe
 * Tak samo jest dla osbo urodzonych przed 1900 rokiem
 */
            int miesiac = Integer.parseInt(monthOfBirth);
            if (miesiac > 80 && miesiac < 93) {
                if (miesiac == 81) monthOfBirth = "01";
                else if (miesiac == 82) monthOfBirth = "02";
                else if (miesiac == 83) monthOfBirth = "03";
                else if (miesiac == 84) monthOfBirth = "04";
                else if (miesiac == 85) monthOfBirth = "05";
                else if (miesiac == 86) monthOfBirth = "06";
                else if (miesiac == 87) monthOfBirth = "07";
                else if (miesiac == 88) monthOfBirth = "08";
                else if (miesiac == 89) monthOfBirth = "09";
                else if (miesiac == 90) monthOfBirth = "10";
                else if (miesiac == 91) monthOfBirth = "11";
                else if (miesiac == 92) monthOfBirth = "12";
            } else if (miesiac > 20 && miesiac < 33) {
                if (miesiac == 21) monthOfBirth = "01";
                else if (miesiac == 22) monthOfBirth = "02";
                else if (miesiac == 23) monthOfBirth = "03";
                else if (miesiac == 24) monthOfBirth = "04";
                else if (miesiac == 25) monthOfBirth = "05";
                else if (miesiac == 26) monthOfBirth = "06";
                else if (miesiac == 27) monthOfBirth = "07";
                else if (miesiac == 28) monthOfBirth = "08";
                else if (miesiac == 29) monthOfBirth = "09";
                else if (miesiac == 20) monthOfBirth = "10";
                else if (miesiac == 31) monthOfBirth = "11";
                else if (miesiac == 32) monthOfBirth = "12";
            } else
                monthOfBirth = idNumber.substring(2, 4);
/**
 * Dodajemy przedrostek roku do dwoch ostatnich cyfr roku pobranego z numeru pesel
 * w zaleznosci jak wyglada miesiac urodzenia
 */
            String epoka;
            int rok = Integer.parseInt(yearOfBirth);
            if (miesiac > 80 && miesiac < 93) {
                epoka = "18";
            } else if (miesiac > 20 && miesiac < 33)
            {
                epoka = "20";
            }else epoka="19";
/**
* Wypisywanie wiadomosci zwrotnej, sprawdzanie czy dni miesiaca nie przekraczaja okreslonych ram (luty!=31)
*/

            String text = getString(R.string.yearOfBirth)+ epoka + yearOfBirth + getString(R.string.newline) +
                    getString(R.string.monthOfBirth)+ monthOfBirth +  getString(R.string.newline) +
                    getString(R.string.dayOfBirth)+ dayOfBirth + getString(R.string.newline) +
                    getString(R.string.gender) + sGender + getString(R.string.newline) +
                    getString(R.string.control) + lKontrolna;
            String textError = "Błędny miesiac w numerze Pesel";
            int dzienMiesiaca = Integer.parseInt(dayOfBirth);

            if(miesiac==01||miesiac==03||miesiac==05||miesiac==07||miesiac==8||miesiac==10||miesiac==12)
                if (dzienMiesiaca>31)
                    tvResult.setText(textError);
                else
                    tvResult.setText(text);

            if(miesiac==04||miesiac==06||miesiac==9||miesiac==11)
                if (dzienMiesiaca>30)
                    tvResult.setText(textError);
                else
                    tvResult.setText(text);

            if (miesiac==02)
                if (dzienMiesiaca>29)
                    tvResult.setText(textError);
                else
                    tvResult.setText(text);


        });











    }



}