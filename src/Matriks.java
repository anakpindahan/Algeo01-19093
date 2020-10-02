import java.util.Scanner; 
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

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
		mout = new double[matriksin.nkol][matriksin.nbrs];
		for(idbrs = 0; idbrs < matriksin.nbrs; idbrs++){
			for(idkol = 0; idkol < matriksin.nkol; idkol++){
				mout[idkol][idbrs] = matriksin.matriks[idbrs][idkol];
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
	
	// Proseddur mengalikan dua buah matriks
	public static Matriks kaliMatriks(Matriks matriks1, Matriks matriks2){
		double temp;
		int idbrs, idkol, id; 
		Matriks matriks = new Matriks(matriks1.nbrs, matriks2.nkol);
		for(idbrs = 0; idbrs < matriks1.nbrs; idbrs++){
			for(idkol = 0; idkol < matriks2.nkol; idkol++){
				for(id = 0; id < matriks1.nkol; id++){
					matriks.matriks[idbrs][idkol] += matriks1.matriks[idbrs][id] * matriks2.matriks[id][idkol];
				}
			}
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
	
	// Prosedur membuat matriks menjadi matriks segitiga bawah
	public static void toMatriksSegitigaBawah(Matriks matriks){ 
        int i, j, k, x;
        boolean brsfullnol;
		double rasio;
		
        for (i = 0; i < Math.min(matriks.nbrs, matriks.nkol); i++){
            if (matriks.matriks[i][i] == 0){
                brsfullnol = true;
                x = i+1;
                while(brsfullnol && (x < matriks.nbrs)){
                    if(matriks.matriks[x][i] != 0){
                        tukarBaris(matriks, x, i);
                        brsfullnol=false;
                        }                  
                    else {
                        x += 1;
                    }
                }
            } 
            else {
                for(j = i+1; j < matriks.nbrs; j++){
                    rasio = matriks.matriks[j][i]/matriks.matriks[i][i];
                    for(k = 0; k < matriks.nkol; k++){
                        matriks.matriks[j][k] -= (matriks.matriks[i][k]*rasio);
                    }
                }
            }
		}
	}

	// Prosedur eliminasi gauss di matriks
	public static void gaussElim(Matriks matriks){
		int idbrs = 0, idkol = 0, i;
		boolean brsfullzero = false;
		boolean foundnonzero;
		toMatriksSegitigaBawah(matriks);
        for (idbrs = 0; idbrs<Math.min(matriks.nbrs, matriks.nkol); idbrs++){
            if (matriks.matriks[idbrs][idbrs] != 0){
                kalikBaris(matriks, idbrs, 1/matriks.matriks[idbrs][idbrs]);
            }
		}
	}

	public static void gaussJordanElim(Matriks matriks){
		gaussElim(matriks);
		int i, j, k;
		double rasio;
		for(i = Math.min(matriks.nbrs, matriks.nkol)-1; i > 0; i--){
			if (matriks.matriks[i][i] != 0){
				for (j= i-1; j>=0; j--){
					rasio = matriks.matriks[j][i]/matriks.matriks[i][i];
					for(k = 0; k < matriks.nkol; k++){
						matriks.matriks[j][k] -= (matriks.matriks[i][k]*rasio);
					}
				}
			}
		}
	}

	//Prosedur Penyelesaian SPL dengan hasil kali matriks balikan
	public static void splInverse(Matriks matriksA, Matriks matriksb){
		Matriks matsub = new Matriks(matriksA.nbrs, matriksA.nkol);
		Matriks matout = new Matriks(matriksb.nbrs, matriksb.nkol);
		
		if((matriksA.nbrs != matriksA.nkol) || (matriksA.nbrs != matriksb.nbrs) || (matriksb.nkol != 1)){
			System.out.println("SPL ini tidak bisa diselesaikan dengan mengalikan balikan matriks");
		} else if(determinan1(matriksA) == 0){
			System.out.println("SPL ini tidak ada solusi");
		} else {
			matsub = inverse1(matriksA);
			matout = kaliMatriks(matsub, matriksb);
			tulisMatriks(transposeMatriks(matout));
		}
		System.out.printf("%n");
	} 
	
	// Prosedur Penyelesaian SPL dengan Kaidah Cramer
	public static void cramer(Matriks matriksA, Matriks matriksb){
		Matriks matsub = new Matriks(matriksA.matriks);
		int idbrs, idkol;
		double det, temp;
		
		if((matriksA.nbrs != matriksA.nkol) || (matriksA.nbrs != matriksb.nbrs) || (matriksb.nkol != 1)){
			System.out.println("SPL ini tidak bisa diselesaikan dengan Cramer");
		} else if(determinan1(matriksA) == 0){
			System.out.println("SPL ini tidak ada solusi");
		} else {
			det = determinan1(matsub);
			for(idkol = 0; idkol < matsub.nkol; idkol++){
				for(idbrs = 0; idbrs < matsub.nbrs; idbrs++){
					matsub.matriks[idbrs][idkol] = matriksb.matriks[idbrs][0];
				}
				temp = determinan1(matsub)/det;
				System.out.printf("%f ", temp);
				for(idbrs = 0; idbrs < matsub.nbrs; idbrs++){
					matsub.matriks[idbrs][idkol] = matriksA.matriks[idbrs][idkol];
				}
			}
		}
		System.out.printf("%n");
	} 
	
	// Fungsi inverse matriks versi 1 - Operasi Baris Elementer
	public static Matriks inverse1(Matriks matriks){
		
		Matriks iden = matriksSatuan(matriks.nbrs);
		Matriks matout = new Matriks(matriks.nbrs, matriks.nkol);
		Matriks fail = new Matriks(1, 1);
		
		double rasio, temp;
		int idbrs, idkol, x, k;
		boolean brsfullnol = true;
		
		// Salin matriks
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			for (idkol = 0; idkol < matriks.nkol; idkol++){
				matout.matriks[idbrs][idkol] = matriks.matriks[idbrs][idkol];
			}
		}
		
		// Jadiin matriks segitiga bawah
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			if (matout.matriks[idbrs][idbrs] == 0){
				brsfullnol = true;
				x = idbrs+1;
				while(brsfullnol && (x < matriks.nbrs)){
					if(matout.matriks[x][idbrs] != 0){
						for(k = 0; k < matriks.nkol; k++){
							matout = tukarBaris(matout, idbrs, x);
							iden = tukarBaris(iden, idbrs, x);
						}
						brsfullnol = false;                    
					} else {
						x += 1;
					}
				}
				if(brsfullnol){
					System.out.println("Matriks singular");
					return fail;
				}
			} else {
				for(idkol = idbrs+1; idkol < matriks.nkol; idkol++){
					rasio = matout.matriks[idkol][idbrs]/matout.matriks[idbrs][idbrs];
					for(k = 0; k < matriks.nkol; k++){
						matout.matriks[idkol][k] -= (matout.matriks[idbrs][k]*rasio);
						iden.matriks[idkol][k] -= (iden.matriks[idbrs][k]*rasio);
					}
				}
			}
		}
		
		// Jadiin matriks segitiga atas
		for(idbrs = matriks.nbrs - 1; idbrs >= 0; idbrs--){
			if (matout.matriks[idbrs][idbrs] == 0){
				brsfullnol = true;
				x = idbrs-1;
				while(brsfullnol && (x >= 0)){
					if(matout.matriks[x][idbrs] != 0){
						for(k = matriks.nkol - 1; k >= 0; k--){
							matout = tukarBaris(matout, idbrs, x);
							iden = tukarBaris(iden, idbrs, x);
						}
						brsfullnol = false;                    
					} else {
						x -= 1;
					}
				}
				if(brsfullnol){
					System.out.println("Matriks singular");
				}
			} else {
				for(idkol = idbrs-1; idkol >= 0; idkol--){
					rasio = matout.matriks[idkol][idbrs]/matout.matriks[idbrs][idbrs];
					for(k = matriks.nkol - 1; k >= 0; k--){
						matout.matriks[idkol][k] -= (matout.matriks[idbrs][k]*rasio);
						iden.matriks[idkol][k] -= (iden.matriks[idbrs][k]*rasio);
					}
				}
			}
		}
		
		// Bagi diagonal
		for(idbrs = 0; idbrs < matriks.nbrs; idbrs++){
			kalikBaris(iden, idbrs, 1/matout.matriks[idbrs][idbrs]);
		}
		
		// return hasil 
		return(iden);
	}
	
	// Fungsi Balikan Matriks versi 2 - Ekspansi Kofaktor
/*	public static Matriks inverse2(Matriks matriks){
		return;
	} */
	
	// Fungsi Determinan Matriks versi 1 - Operasi Baris Elementer
	public static double determinan1(Matriks matriks){

		// KAMUS
		Matriks matout = new Matriks(matriks.nbrs, matriks.nkol);
		double det = 1;
		int i, j, k, x;
		double ntukar = 1;
		boolean brsfullnol;
		double rasio, temp;
		
		// ALGORITMA
		
		// Salin matriks
		for(i = 0; i < matriks.nbrs; i++){
			for (j = 0; j < matriks.nkol; j++){
				matout.matriks[i][j] = matriks.matriks[i][j];
			}
		}
		
		// Jadiin matriks segitiga bawah
		for (i = 0; i < matriks.nbrs; i++){
			if (matout.matriks[i][i] == 0){
				brsfullnol = true;
				x = i+1;
				while(brsfullnol && (x < matriks.nbrs)){
					if(matout.matriks[x][i] != 0){
						for(k = 0; k < matriks.nkol; k++){
							temp = matout.matriks[i][k];
							matout.matriks[i][k] = matout.matriks[x][k];
							matout.matriks[x][k] = temp;
						}
						ntukar *= -1;
						brsfullnol = false;                    
					} else {
						x += 1;
					}
				}
				if(brsfullnol){
					det = 0;
				}
			} else {
				for(j = i+1; j < matriks.nkol; j++){
					rasio = matout.matriks[j][i]/matout.matriks[i][i];
					for(k = 0; k < matriks.nkol; k++){
						matout.matriks[j][k] -= (matout.matriks[i][k]*rasio);
					}
				}
			}
		}
		
		// Get the det
		for(i = 0; i < matriks.nbrs; i++){
			det *= matout.matriks[i][i];
		}
		
		return(det);
	}
		
	// Fungsi Determinan Matriks versi 2 - Metode Ekspansi Kofaktor
	public static double determinan2(Matriks M){
		if ((M.nbrs*M.nkol)== 4) return ((float)((M.matriks[0][0] * M.matriks[1][1]) - (M.matriks[1][0] * M.matriks[0][1])));
		float res = 0;
		boolean tf = false;
		int posneg = 0, temp = 0;
		Matriks mtemp =  new Matriks(M.nbrs - 1,M.nkol - 1);
		for (int i = 0 ; i < M.nbrs ; i++) {
			temp = 0;
			tf = false;
			for (int j = 0; j < mtemp.nbrs ; j++) {
				for (int k = 0; k < mtemp.nkol ; k++) {
					if((j == i) && !tf) {
						temp++;
						tf = true;
					}
					mtemp.matriks[j][k] = M.matriks[temp][k+1];
				}
				temp++;
			}
			posneg = 1 - 2 * (i & 1);
			res += (M.matriks[i][0] * determinan2(mtemp) * posneg);
		}
		return res;
	} 

	// Fungsi baca titik
	public static void bacatitikjadimatriks(double[][] matriks){
		int idbrs, idkol;
		System.out.println("Masukkan titik titik");

		Scanner input = new Scanner(System.in);
		
	
		for(idbrs=0; idbrs<matriks.length; idbrs++){
			System.out.print("masukkan titik x (spasi) y: ");
			double x = input.nextDouble();
			double y = input.nextDouble();
			matriks[idbrs][matriks[0].length-1] = y;
	
			for(idkol = 0; idkol < matriks[0].length-1; idkol++){
				matriks[idbrs][idkol] = Math.pow(x, idkol);
			}
		}
	}
	
	public static void interpolasi(){
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Masukkan banyaknya titik: ");
		n = sc.nextInt();
		double[][] matriks;
		matriks = new double[n][n+1];
	
		bacatitikjadimatriks(matriks);
		Matriks matrix = new Matriks(matriks);
		gaussJordanElim (matrix);
		System.out.println("koefisien dari x^0 sampai x^(n-1) adalah: ");
		int i;
		for (i = 0; i<n-1; i++){
			System.out.printf("%f ", matrix.matriks[i][n]);
		}
		System.out.printf("%f\n", matrix.matriks[n-1][n]);

		int pilih;
		double x;
		System.out.println("Pilih 0 untuk ke menu utama, pilih 1 untuk menaksir nilai f(x): ");
		pilih = sc.nextInt();
		while (pilih == 1){
			double hasil = 0;
			System.out.println("Masukkan x yang ingin ditaksir: ");
			x = sc.nextDouble();
			for (i = 0; i<n; i++){
				hasil += Math.pow(x, i)* matrix.matriks[i][n];
			}
			System.out.printf("nilai f(x) adalah %f\n", hasil);

			System.out.println("Pilih 0 untuk ke menu utama, pilih 1 untuk menaksir nilai f(x): ");
			pilih = sc.nextInt();
		}
	}
		

	// Prosedur menu utama
	public static void main(String[] args){
		boolean akses = true, valid, validspl, validdet, validinv;
		int pilihan = 0, pilspl = 0, pildet = 0, pilinv = 0;
		int brs = 0, kol = 0;
		Scanner sc = new Scanner(System.in);
		double[][] isimatriks;
		String fileName = "src/outputt.txt";
		while(akses){
			valid = false;
			System.out.println("---------UwU---------");
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
							Matriks outt = matriks11;
							try {
            					FileWriter fileWriter = new FileWriter(fileName);
            					fileWriter.write(outt);
            					fileWriter.close();
        					} 
        					catch (IOException e) {
            					System.out.println("ups salah" + e.getMessage());
        					}
							tulisMatriks(matriks11);
							break;
						case 2:
							isimatriks = bacaIsiMatriks();
							Matriks matriks12 = new Matriks(isimatriks);
							
							gaussJordanElim(matriks12);
							tulisMatriks(matriks12);
							break;
						case 3:
							isimatriks = bacaIsiMatriks();
							Matriks matriks131 = new Matriks(isimatriks);
							isimatriks = bacaIsiMatriks();
							Matriks matriks132 = new Matriks(isimatriks);
							splInverse(matriks131, matriks132);
							break;
						case 4:
							isimatriks = bacaIsiMatriks();
							Matriks matriks141 = new Matriks(isimatriks);
							isimatriks = bacaIsiMatriks();
							Matriks matriks142 = new Matriks(isimatriks);
							cramer(matriks141, matriks142);
							break;
					}
					break;
				case 2:
					validdet = false;
					System.out.println("1. Metode Operasi Baris Elementer");
					System.out.println("2. Metode Kofaktor");
					while(!validdet){
						System.out.println("Pilih menu yang ingin dipilih dengan angka 1-2: ");
						pildet = sc.nextInt();
						if(pildet > 2 || pildet < 1){
							System.out.println("Pilihan tidak ada. Masukkan kembali");
						} else {
							validdet = true;
						}
					}
					switch(pildet){
						case 1:
							isimatriks = bacaIsiMatriks();
							Matriks matriks21 = new Matriks(isimatriks);
							System.out.printf("Determinan matriks ini adalah %f%n", determinan1(matriks21));
							break;
						case 2:
							isimatriks = bacaIsiMatriks();
							Matriks matriks22 = new Matriks(isimatriks);
							System.out.printf("Determinan matriks ini adalah %f%n", determinan2(matriks22));
							break;							
					}
					break;
				case 3:
					validinv = false;
					System.out.println("1. Metode Operasi Baris Elementer");
					System.out.println("2. Metode Kofaktor");
					while(!validinv){
						System.out.println("Pilih menu yang ingin dipilih dengan angka 1-2: ");
						pilinv = sc.nextInt();
						if(pilinv > 2 || pilinv < 1){
							System.out.println("Pilihan tidak ada. Masukkan kembali");
						} else {
							validinv = true;
						}
					}
					switch(pilinv){
						case 1:
							isimatriks = bacaIsiMatriks();
							Matriks matriks31 = new Matriks(isimatriks);
							System.out.println("Balikan matriks ini adalah");
							tulisMatriks(inverse1(matriks31)); 
							break;
						case 2:
							isimatriks = bacaIsiMatriks();
							Matriks matriks32 = new Matriks(isimatriks);
							//System.out.printf("Balikan matriks ini adalah %f%n", inverse2(matriks22));
							break;							
					}
					break;
				case 4:
					interpolasi();
					
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