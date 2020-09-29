import java.util.Scanner;

public class Matriks{
	// Atribut matriks
	int nbrs; 				// Banyak baris 
	int nkol;				// Banyak kolom
	double[][] matriks;		// Matriks (array of array)
	
	// Konstruktor Matriks versi 1
	public Matriks(int brs, int kol){
		nbrs = brs;
		nkol = kol;
		matriks = new double[nbrs][nkol];
	}

	// Konstruktor Matriks versi 2
	public Matriks(double[][] m){
		int idbrs, idkol;
		nbrs = m.length;
		nkol = m[0].length;
		matriks = new double[nbrs][nkol];
		for(idbrs = 0; idbrs < nbrs; idbrs++){
			for(idkol = 0; idkol < nkol; idkol++){
				matriks[idbrs][idkol] = m[idbrs][idkol];
			}
		}
	}

	// Prosedur menukar nilai dua variabel integer
	public static void swapp(int a, int b){
		int tmp = a;
		a = b;
		b = tmp;
	}
	
	// Prosedur menukar nilai dua variabel double
	public static void swapp(double a, double b){
		double tmp = a;
		a = b;
		b = tmp;
	}
	
	// Fungsi membaca isi matriks dari masukan pengguna
	public static double[][] bacaIsiMatriks(){
		int nbrs, nkol, idbrs, idkol;
		double[][] matriks;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Masukkan banyak baris: ");
		nbrs = sc.nextInt();
		
		System.out.println("Masukkan banyak kolom: ");
		nkol = sc.nextInt();
		
		matriks = new double[nbrs][nkol];
		
		System.out.println("Masukkan matriks");
		for(idbrs = 0; idbrs < nbrs; idbrs++){
			for(idkol = 0; idkol < nkol; idkol++){
				matriks[idbrs][idkol] = sc.nextDouble();
			}
		}
		return(matriks);
	}
	
	// Fungsi menghitung transpose
	public static Matriks transposeMatriks(Matriks matriksin){
		int idbrs, idkol;
		double[][] mout;
		mout = new double[matriksin.nbrs][matriksin.nkol];
		for(idbrs = 0; idbrs < matriksin.nbrs; idbrs++){
			for(idkol = 0; idkol < matriksin.nkol; idkol++){
				mout[idbrs][idkol] = matriksin.matriks[idkol][idbrs];
			}
		}
		Matriks matriksout = new Matriks(mout);
		return(matriksout);
	}
	
	// Prosedur menukar dua baris dari matriks
	public static Matriks tukarBaris(Matriks matriks, int brs1, int brs2){
		int idkol;
		double temp;
		
		for(idkol = 0; idkol < matriks.nkol; idkol++){
			temp = matriks.matriks[brs1][idkol];
			matriks.matriks[brs1][idkol] = matriks.matriks[brs2][idkol];
			matriks.matriks[brs2][idkol] = temp;
		}
		return(matriks);
	}
	
	// Prosedur menukar dua kolom dari matriks
	public static Matriks tukarKolom(Matriks matriks, int kol1, int kol2){
		int idbrs;
		double temp;
		
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			temp = matriks.matriks[idbrs][kol1];
			matriks.matriks[idbrs][kol1] = matriks.matriks[idbrs][kol2];
			matriks.matriks[idbrs][kol2] = temp;
		}
		return(matriks);
	}
	
	// Fungsi mengecek apakah sebuah matriks SPL punya solusi
	public static boolean isTanpaSolusi(Matriks matriks){
		int idkol = 0;
		boolean kons = true;
		while(kons && (idkol < matriks.nkol)){
			if(matriks.matriks[matriks.nbrs - 1][idkol] != 0){
				kons = false;
			}
		}
		return(kons);
	}
	
	// Prosedur menambahkan baris brsdiff dengan k kali baris brssame
	public static Matriks pluskBaris(Matriks matriks, int brssame, int brsdiff, double k){
		int idkol;
		for(idkol = 0; idkol < matriks.nkol; idkol++){
			matriks.matriks[brsdiff][idkol] += k*matriks.matriks[brssame][idkol];
		}
		return(matriks);
	}
	
	// Prosedur menambahkan baris brsdiff dengan k kali baris brssame
	public static Matriks pluskKolom(Matriks matriks, int kolsame, int koldiff, double k){
		int idbrs;
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			matriks.matriks[idbrs][koldiff] += k*matriks.matriks[idbrs][kolsame];
		}
		return(matriks);
	}
	
	// Prosedur mengalikan baris brs dengan k
	public static Matriks kalikBaris(Matriks matriks, int brs, double k){
		int idkol;
		for(idkol = 0; idkol < matriks.nkol; idkol++){
			matriks.matriks[brs][idkol] *= k;
		}
		return(matriks);
	}
	
	// Prosedur mengalikan kolom kol dengan k
	public static Matriks kalikKolom(Matriks matriks, int kol, double k){
		int idbrs;
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			matriks.matriks[idbrs][kol] *= k;
		}
		return(matriks);
	}
	
	// Prosedur menuliskan matriks ke layar
	public static void tulisMatriks(Matriks matriks){
		int idbrs, idkol;
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			for(idkol = 0; idkol < matriks.nkol - 1; idkol++){
				System.out.printf("%f ", matriks.matriks[idbrs][idkol]);
			}
			System.out.printf("%f%n", matriks.matriks[idbrs][matriks.nkol -1]);
		}
	}
	
	// Fungsi membuat matriks satuan
	public static Matriks matriksSatuan(int n){
		Matriks iden = new Matriks(n,n);
		int idbrs, idkol;
		
		for(idbrs = 0; idbrs < n; idbrs++){
			for(idkol = 0; idkol < n; idkol++){
				if(idbrs == idkol){
					iden.matriks[idbrs][idkol] = 1;
				} else {
					iden.matriks[idbrs][idkol] = 0;
				}
			}
		}
		
		return(iden);
	}
	
	//Prosedur membuat matriks menjadi segitiga atas
	public static Matriks toMatriksSegitigaAtas(Matriks matriks){
		int idbrs, idkol, cidbrs, lastidbrs = matriks.nbrs - 1;
		boolean kolfullzero;
	
		for(idkol = matriks.nkol - 1; idkol >= 0; idkol--){
			kolfullzero = true;
			idbrs = matriks.nbrs - 1;
			while(kolfullzero && idbrs >= 0){
				if(matriks.matriks[idbrs][idkol] != 0){
					kolfullzero = false;
				} else {
					idbrs--;
				}
			}
			cidbrs = idbrs;
			
			matriks = tukarBaris(matriks, cidbrs, lastidbrs);
			
			for(idbrs = cidbrs - 1; idbrs >=0; idbrs--){
				if(matriks.matriks[idbrs][idkol] != 0){
					matriks = pluskBaris(matriks, idbrs, lastidbrs, -(matriks.matriks[lastidbrs][idkol]/matriks.matriks[idbrs][idkol]));
				}
			}
			
			lastidbrs--;
		}
		return(matriks);
	}
	
	// Prosedur membuat matriks menjadi matriks segitiga bawah
	public static void toMatriksSegitigaBawah(Matriks matriks){
		int idbrs, idkol, cidbrs, frstidbrs = 0;
		boolean kolfullzero;
		
		for(idkol = 0; idkol < matriks.nkol; idkol++){
			kolfullzero = true;
			idbrs = 0;
			while(kolfullzero && (idbrs < matriks.nbrs)){
				if(matriks.matriks[idbrs][idkol] != 0){
					kolfullzero = false;
				} else {
					idbrs++;
				}
			}
			cidbrs = idbrs;
			
			tukarBaris(matriks, cidbrs, frstidbrs);
			
			for(idbrs = cidbrs + 1; idbrs < matriks.nbrs; idbrs++){
				if(matriks.matriks[idbrs][idkol] != 0){
					pluskBaris(matriks, frstidbrs, idbrs, -(matriks.matriks[frstidbrs][idkol]/matriks.matriks[idbrs][idkol]));
				}
			}
			
			frstidbrs++;
		}
	}
	
	// Prosedur eliminasi gauss di matriks
	public static void gaussElim(Matriks matriks){
		int idbrs = 0, idkol = 0;
		boolean brsfullzero = false;
		boolean foundnonzero;
		toMatriksSegitigaBawah(matriks);
		while(!brsfullzero && idbrs < matriks.nbrs){
			foundnonzero = false;
			while(!foundnonzero && idkol < matriks.nkol){
				if(matriks.matriks[idbrs][idkol] != 0){
					kalikBaris(matriks, idbrs, 1/matriks.matriks[idbrs][idkol]);
					foundnonzero = true;
				}
			}
			if(!foundnonzero){
				brsfullzero = true;
			}
			idbrs++;
		}
		tulisMatriks(matriks);
	}
	
	// Prosedur inverse matriks versi 1
	public static Matriks inverse1(Matriks matriks){
		
		Matriks iden = matriksSatuan(matriks.nbrs);
		
		int idbrs = 0, idkol = 0;
		boolean brsfullzero = false;
		boolean foundnonzero;
		
		toMatriksSegitigaBawah(matriks);
		while(!brsfullzero && idbrs < matriks.nbrs){
			foundnonzero = false;
			while(!foundnonzero && idkol < matriks.nkol){
				if(matriks.matriks[idbrs][idkol] != 0){
					kalikBaris(matriks, 1/idbrs, matriks.matriks[idbrs][idkol]);
					foundnonzero = true;
				}
			}
			if(!foundnonzero){
				brsfullzero = true;
			}
			idbrs++;
		}
		
		return(matriks);
	}
	
	// Fungsi determinan
	public static double determinan(Matriks matriks){
		return(0);
	}
		
	// Prosedur menu utama
	public static void main(String[] args){
		boolean akses = true, valid, validspl;
		int pilihan = 0, pilspl = 0;
		int brs = 0, kol = 0;
		Scanner sc = new Scanner(System.in);
		double[][] isimatriks;
		
		while(akses){
			valid = false;
			System.out.println("MENU");
			System.out.println("1. Sistem Persamaan Linear");
			System.out.println("2. Determinan");
			System.out.println("3. Matriks balikan");
			System.out.println("4. Interpolasi Polinom");
			System.out.println("5. Regresi linear berganda");
			System.out.println("6. Keluar");
			while(!valid){
				System.out.println("Pilih menu yang ingin dipilih dengan angka 1-6: ");
				pilihan = sc.nextInt();
				if(pilihan > 6 || pilihan < 1){
					System.out.println("Pilihan tidak ada. Masukkan kembali");
				} else {
					valid = true;
				}
			}
			switch(pilihan){
				case 1:
					validspl = false;
					System.out.println("1. Metode Eliminasi Gauss");
					System.out.println("2. Metode Eliminasi Gauss-Jordan");
					System.out.println("3. Metode Matriks Balikan");
					System.out.println("4. Kaidah Cramer");
					while(!validspl){
						System.out.println("Pilih menu yang ingin dipilih dengan angka 1-4: ");
						pilspl = sc.nextInt();
						if(pilihan > 4 || pilihan < 1){
							System.out.println("Pilihan tidak ada. Masukkan kembali");
						} else {
							validspl = true;
						}
					}
					switch(pilspl){
						case 1:
							isimatriks = bacaIsiMatriks();
							Matriks matriks11 = new Matriks(isimatriks);
							
							gaussElim(matriks11);
							// tulisMatriks(matriks);
							break;
						case 2:
							isimatriks = bacaIsiMatriks();
							Matriks matriks12 = new Matriks(isimatriks);
							
							// gaussJordanElim(matriks);
							// tulisMatriks(matriks);
							break;
						case 3:
							isimatriks = bacaIsiMatriks();
							Matriks matriks13 = new Matriks(isimatriks);
							
							break;
						case 4:
							isimatriks = bacaIsiMatriks();
							Matriks matriks14 = new Matriks(isimatriks);
							
							break;
					}
					break;
				case 2:
					isimatriks = bacaIsiMatriks();
					Matriks matriks2 = new Matriks(isimatriks);
					
					System.out.println(determinan(matriks2));
					break;
				case 3:
					isimatriks = bacaIsiMatriks();
					Matriks matriks3 = new Matriks(isimatriks);
					
					System.out.println(inverse1(matriks3));
					break;
				case 4:
					isimatriks = bacaIsiMatriks();
					Matriks matriks4 = new Matriks(isimatriks);
					
					break;
				case 5:
					isimatriks = bacaIsiMatriks();
					Matriks matriks5 = new Matriks(isimatriks);
					
					break;
				case 6:
					akses = false;
					break;
			}
		}
	}
}