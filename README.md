# DataOutputStream, DataInputStream

## FileWriteDataOutputStreamInt (Es.1)

L'obiettivo di questo esercizio è l'utilizzo delle classi **FileOutputStream** e **DataOutputStream**.

Creare la classe `FileWriteDataOutputStreamInt` con il relativo JUnit di test `FileWriteDataOutputStreamIntTest`.

Leggere da un file di testo `integer.txt`, per ogni riga, un numero variabile
di interi e scriverli sullo stream di output, nel file `integer.dat`, dove verranno scritti in sequenza in formato byte.

### Output (Es.1)

Scrivere all'interno del file `integer.dat` gli interi letti dal file `integer.txt` sotto forma di byte.

### Consigli (Es.1)

Lo stream di output sarà definito in questo modo:

```java
DataOutputStream out = new DataOutputStream(new FileOutputStream("integer.dat"));
```

Utilizza il metodo `out.writeInt()` per scrivere gli interi nel file `integer.dat`.

## Files (Es.1)

**integer.txt**

```txt
1 3 5 6
25 60
345 89 45 2 4 98
```

## FileReadDataInputStreamInt (Es.2)

L'obiettivo di questo esercizio è l'utilizzo delle classi **FileInputStream** e **DataInputStream**.

Creare la classe `FileReadDataInputStreamInt` con il relativo JUnit di test.

Leggere gli interi dal file `integer.dat` creato nell'esercizio precedente e stampare a in console gli interi letti insieme alla loro somma.

> **Nota:** Non utilizzare lo Scanner per la lettura degli interi.

Lo stream di input sarà definito in questo modo:

### Output (Es.2)

Stampare in console gli interi letti dal file `integer.dat` e la loro somma.

### Consigli (Es.2)

```java
DataInputStream in = new DataInputStream(new FileInputStream("integer.dat")
```

## Files (Es.2)

**integer.dat** (Esempio)

```dat
<YY-b
```
