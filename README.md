# Library API APP
![Library API APP](https://github.com/Leeroyakbar/library_api/assets/71091549/2ee58d02-0e24-4946-931a-fe5637616d0f)

`Library API APP` merupakan Sebuah applikasi API untuk melakukan pencatatan peminjaman buku di perpustakaan. API ini merupakan sistem yan gmemungkinkan pengguna untuk melakukan berbagai tindakan seperti peminjaman buku, pendaftaran anggota baru perpustakaan, manajemen katalog buku, dan proses peminjaman serta pengembalian buku.

*API ini dibuat menggunakan Java dengan Spring Framework*

## Endpoint Usage
---
1. Create New Book
   - Endpoint : `/api/books`
   - Method   : POST
   - Body
     ```JSON
     {
        "title" : "string",
        "author" : "string",
        "yearPublished" : "string"
     }
     ```
   - Response
     ```JSON
     {
        "statusCode": 201,
        "message": "successfully created data",
        "data": {
           "id": "5bbc0a9a-e4df-4eaa-af47-60cfbaffb2cf",
           "title": "seni untuk bersikap bodo amat",
           "author": "mark manson",
           "yearPublished": "2022"
         }
     }
     ```
