# Library API APP
![Library API APP](https://github.com/Leeroyakbar/library_api/assets/71091549/2ee58d02-0e24-4946-931a-fe5637616d0f)

`Library API APP` merupakan Sebuah applikasi API untuk melakukan pencatatan peminjaman buku di perpustakaan. API ini merupakan sistem yan gmemungkinkan pengguna untuk melakukan berbagai tindakan seperti peminjaman buku, pendaftaran anggota baru perpustakaan, manajemen katalog buku, dan proses peminjaman serta pengembalian buku.

*API ini dibuat menggunakan Java dengan Spring Framework*

## Endpoint Usage
---
1. Create New Book
   | Endpoint | `api/books` |
   | Method | POST |
   | Header | `- Content-Type : application/json`
              `- Accept : application/json`  |
   | Body | ```
             {
                "title" : "string",
                "author" : "string",
                "yearPublished" : "string"
             }
           ``` |
   | Response | ```
                  {
                      "statusCode": int,
                      "message": "string",
                      "data": {
                          "id": "string",
                          "title": "string",
                          "author": "string",
                          "yearPublished": "string"
                      }
                  }

                 ``` |
