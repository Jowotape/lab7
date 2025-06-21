package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import prob1.*;
import prob2.*;
import prob3.*;
import prob4.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Prob1 prob1 = new Prob1();
        Prob2 prob2 = new Prob2();

        prob1.problemarse1(br);
        prob2.problemarse2(br);
    }
}