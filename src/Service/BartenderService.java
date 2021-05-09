package Service;

import Comparator.AgeComparator;
import Comparator.HireDateComparator;
import Comparator.ServedClientsComparator;
import Comparator.SignatureDrinkComparator;
import Employee.Bartender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


import static FileManager.FileService.writeWithAppend;

public class BartenderService {

    //FullNames
    public void writeFullNamesSortedByHireDate(ArrayList<Bartender> bartenders) throws IOException {
        writeWithAppend("FileService\\bartenderOutput.txt","Method #1\n");
        Collections.sort(bartenders,new HireDateComparator());
        for(Bartender bartender: bartenders) {
            writeWithAppend("FileService\\bartenderOutput.txt",bartender.getFullName()+"\n");
        }
    }

    public void writeOldestBartender(ArrayList<Bartender> bartenders) throws  IOException{

        writeWithAppend("FileService\\bartenderOutput.txt","Method #2\n");
        writeWithAppend("FileService\\bartenderOutput.txt",Collections.max(bartenders,new AgeComparator()).toString()+"\n");
    }

    public void sortBartendersServingAlcoholBySignatureDrink(ArrayList<Bartender> bartenders) throws IOException {
        writeWithAppend("FileService\\bartenderOutput.txt","Method #3\n");

        Collections.sort(bartenders,new SignatureDrinkComparator());
        for(Bartender bartender : bartenders) {
            if(bartender.isServingAlcohol()) {
                writeWithAppend("FileService\\bartenderOutput.txt", bartender.toString()+"\n");
            }
        }
    }

    public void sortBartenderByReversedNumberOfServedClients(ArrayList<Bartender> bartenders) throws IOException {
        writeWithAppend("FileService\\bartenderOutput.txt","Method #4\n");
        Collections.sort(bartenders, new ServedClientsComparator());
        for(Bartender bartender: bartenders) {
            writeWithAppend("FileService\\bartenderOutput.txt",bartender.toString()+"\n");
        }
    }




}
