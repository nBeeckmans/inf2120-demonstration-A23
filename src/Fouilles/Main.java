package Fouilles;

import java.util.Arrays;

import static Fouilles.AlgoFouille.fouilleBinaire;

public class Main {

		public static Fraction[] fraction1 = { new Fraction(1,20) };
		public static Fraction[] fraction2 = { new Fraction(1,20), new Fraction(4,5) };
		public static Fraction[] fraction3 = { new Fraction(),
				new Fraction(1,20),
				new Fraction(6,2) };

		public static Fraction[] fraction16 = {
				new Fraction(),
				new Fraction(1,20),
				new Fraction(2, 20),
				new Fraction(3, 20),
				new Fraction(4, 20),
				new Fraction(5, 20),
				new Fraction(6, 20),
				new Fraction(7, 20),
				new Fraction(8, 20),
				new Fraction(9, 20),
				new Fraction(10, 20),
				new Fraction(11, 20),
				new Fraction(12, 20),
				new Fraction(13, 20),
				new Fraction(14, 20),
				new Fraction(15, 20),
		};

 	public static void main(String[] args) {
		testsFouilleBinaireSimple();
		testsFouilleBinaireRecursive();
	}

	public static void testTrouverBinaireSimple1(){
		System.out.println(" trouver dans tableau 1 element ");
		System.out.println(fouilleBinaire( Main.fraction1 , new Fraction(1,20)));
	}

	public static void testPasTrouverBinaireSimple1(){
		System.out.println(" pas trouver dans tableau 1 element ");
		System.out.println(fouilleBinaire( Main.fraction1 , new Fraction(0,1)));
	}

	public static void testTrouverBinaireSimple2() {
		System.out.println(" trouver dans tableau 2 elements ");
		System.out.println(fouilleBinaire( Main.fraction2 , new Fraction(4,5)));
	}
	public static void testPasTrouverBinaireSimple2() {
		System.out.println(" pas trouver dans tableau 2 elements ");
		System.out.println(fouilleBinaire( Main.fraction2 , new Fraction(-1,1)));
	}

	public static void testGaucheTrouverBinaireSimple3() {
		System.out.println(" trouver gauche dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction()));
	}

	public static void testDroiteTrouverBinaireSimple3() {
		System.out.println(" trouver droite dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(6,2)));

	}

	public static void testPasTrouverBinaireSimple3() {
		System.out.println(" pas trouver dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(-1,1)));

	}
	public static void testGaucheTrouverBinaireSimple16() {
		System.out.println(" trouver gauche dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(3,20)));

	}

	public static void testDroiteTrouverBinaireSimple16() {
		System.out.println(" trouver droite dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(12,20)));

	}

	public static void testPasTrouverBinaireSimple16() {
		System.out.println(" pas trouver dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(-1,1)));

	}
	public static void testMilieuTrouverBinaireSimple3(){
		System.out.println(" trouver au milieu dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(1,20)));
	}

	public static void testMilieuTrouverBinaireSimple16(){
		System.out.println(" trouver au milieu dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(8,20)));
	}
	public static void testsFouilleBinaireSimple(){
		System.out.println("tests sur fouille binaire simple");
		testTrouverBinaireSimple1();
		testPasTrouverBinaireSimple1();
		testTrouverBinaireSimple2();
		testPasTrouverBinaireSimple2();
		testGaucheTrouverBinaireSimple3();
		testDroiteTrouverBinaireSimple3();
		testMilieuTrouverBinaireSimple3();
		testPasTrouverBinaireSimple3();
		testGaucheTrouverBinaireSimple16();
		testDroiteTrouverBinaireSimple16();
		testMilieuTrouverBinaireSimple16();
		testPasTrouverBinaireSimple16();
	}
	public static void testTrouverBinaireRecursive1(){
		System.out.println(" trouver dans tableau 1 element ");
		System.out.println(fouilleBinaire( Main.fraction1 , new Fraction(1,20), 0, Main.fraction1.length));
	}

	public static void testPasTrouverBinaireRecursive1(){
		System.out.println(" pas trouver dans tableau 1 element ");
		System.out.println(fouilleBinaire( Main.fraction1 , new Fraction(0,1), 0, Main.fraction1.length));
	}

	public static void testTrouverBinaireRecursive2() {
		System.out.println(" trouver dans tableau 2 elements ");
		System.out.println(fouilleBinaire( Main.fraction2 , new Fraction(4,5), 0, Main.fraction2.length));
	}
	public static void testPasTrouverBinaireRecursive2() {
		System.out.println(" pas trouver dans tableau 2 elements ");
		System.out.println(fouilleBinaire( Main.fraction2 , new Fraction(-1,1), 0, Main.fraction2.length));
	}

	public static void testGaucheTrouverBinaireRecursive3() {
		System.out.println(" trouver gauche dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(), 0, Main.fraction3.length));
	}

	public static void testDroiteTrouverBinaireRecursive3() {
		System.out.println(" trouver droite dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(6,2), 0, Main.fraction3.length));

	}

	public static void testPasTrouverBinaireRecursive3() {
		System.out.println(" pas trouver dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(-1,1), 0, Main.fraction3.length));

	}
	public static void testGaucheTrouverBinaireRecursive16() {
		System.out.println(" trouver gauche dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(3,20), 0, Main.fraction16.length));

	}

	public static void testDroiteTrouverBinaireRecursive16() {
		System.out.println(" trouver droite dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(12,20), 0, Main.fraction16.length));

	}

	public static void testPasTrouverBinaireRecursive16() {
		System.out.println(" pas trouver dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(-1,1), 0, Main.fraction16.length));

	}
	public static void testMilieuTrouverBinaireRecursive3(){
		System.out.println(" trouver au milieu dans tableau 3 elements ");
		System.out.println(fouilleBinaire( Main.fraction3 , new Fraction(1,20), 0, Main.fraction3.length));
	}

	public static void testMilieuTrouverBinaireRecursive16(){
		System.out.println(" trouver au milieu dans tableau 16 elements ");
		System.out.println(fouilleBinaire( Main.fraction16 , new Fraction(8,20), 0, Main.fraction16.length));
	}
	public static void testsFouilleBinaireRecursive(){
		System.out.println("tests sur fouille binaire Recursive");
		testTrouverBinaireRecursive1();
		testPasTrouverBinaireRecursive1();
		testTrouverBinaireRecursive2();
		testPasTrouverBinaireRecursive2();
		testGaucheTrouverBinaireRecursive3();
		testDroiteTrouverBinaireRecursive3();
		testMilieuTrouverBinaireRecursive3();
		testPasTrouverBinaireRecursive3();
		testGaucheTrouverBinaireRecursive16();
		testDroiteTrouverBinaireRecursive16();
		testMilieuTrouverBinaireRecursive16();
		testPasTrouverBinaireRecursive16();
	}

}
