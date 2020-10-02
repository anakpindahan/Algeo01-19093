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
		
	// Fungsi Determinan Matriks versi 2 - Metode ekspansi kofaktor
	//public static double determinan2(Matriks matriks){
	//	return(0);
	//}
	public static double detekspansikofaktor(Matriks m){
    	int msize = m.length * m.length, posneg, temp;
		boolean tf;
    	double res = 0;
		if(msize == 1)	return m[0][0];
   		if(msize == 4)  return ((m[0][0] * m[1][1]) - (m[0][1] * m[1][0]));
    	Matriks mtemp = new Matriks[m.length][m.length];
    	for(int i = 0; i < m.length - 1; i++){
        	temp = 0;
        	tf = false;
        	for (int j = 0; j < m.length - 1 ; j++) {
            	for (int k = 0 ; k < m.length - 1 ; k++) {
                	if((j == i) && !tf) {
                    	temp++;
                    	tf = true;
                	}
                	mtemp[j][k] = m[temp][k + 1];
            	}
            	temp++;
        	}
        	posneg = 1 - (2 * (i & 1));
        	res += (m[i][0] * detekspansikofaktor(mtemp) * posneg);
    	}
    	return res; 
	} 
	
/*	public static double deteselonbaris(double[][] m, int[] idx){
    	double[] n;
		double res = 1;
		double temp1, temp2;
    	n = new double[m.length];
    	for(int i = 0; i < m.length; i++)   idx[i] = i;
    	for(int i = 0; i < m.length; i++){
        	temp1 = 0;
        	for(int j = 0; j < m.length; j++){
            	temp2 = m[i][j];
            	if((Math.abs(temp2) > temp1))   temp2 = temp1;
        	}
        	n[i] = temp2;
    	}
    	int temp = 0;
    	for(int j = 0; j < m.length - 1; j++){
        	temp1 = 0;
        	for(int i = j; i < m.length; i++){
            	temp2 = Math.abs(m[idx[i]][j]) / n[idx[i]];
            	if(temp2 > temp1){
                	temp1 = temp2;
                	temp = i;
            	}
        	}
        	swapp(idx[j], idx[temp]);
        	for(int i = j + 1; i < m.length; i++){
            	double eselon = m[idx[i]][j] / m[idx[j]][j];
            	m[idx[i]][j] = eselon;
            	for(int k = j + 1; k < m.length; k++)   m[idx[i]][k] -= (eselon * m[idx[j]][i]);
        	}
    	}
    	for(int i = 0; i < m.length; i++)   res *= m[i][i];
    	return (res);
	} */

	// Prosedur menu utama
	public static void main(String[] args){
		boolean akses = true, valid, validspl, validdet, validinv;
		int pilihan = 0, pilspl = 0, pildet = 0, pilinv = 0;
		int brs = 0, kol = 0;
		Scanner sc = new Scanner(System.in);
		double[][] isimatriks;
		
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
							//System.out.printf("Determinan matriks ini adalah %f%n", detekspansikofaktor(matriks22.matriks));
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