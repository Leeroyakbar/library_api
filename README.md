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
2. Get Book
   - Endpoint : `/api/books/{id}`
   - Method   : GET
   - Response :
     ```JSON
     {
        "statusCode": 200,
        "message": "successfully get data",
        "data": {
           "id": "d7e7eee1-2512-43ea-8c1a-96e872a5f886",
           "title": "segala galanya ambyar",
           "author": "mark manson",
           "yearPublished": "2022"
        }
     }
     ```

4. Get All Books
   - Endpoint : `/api/books`
   - Method   : GET
   - Response :
     ```JSON
     {
       "statusCode": 200,
       "message": "successfully get data",
       "data": [
           {
               "id": "d7e7eee1-2512-43ea-8c1a-96e872a5f886",
               "title": "segala galanya ambyar",
               "author": "mark manson",
               "yearPublished": "2022"
           },
           {
               "id": "5bbc0a9a-e4df-4eaa-af47-60cfbaffb2cf",
               "title": "seni untuk bersikap bodo amat",
               "author": "mark manson",
               "yearPublished": "2022"
           }
       ]
      }
     ```
5. Update Book
   - Endpoint : `/api/books`
   - Method   : PUT
   - Body     :
     ```JSON
     {
          "id": "5bbc0a9a-e4df-4eaa-af47-60cfbaffb2cf",
          "title": "seni untuk bersikap bodo amat",
          "author": "mark manson",
          "yearPublished": "2018"
      }
     ```
   - Response   :
     ```JSON
      {
          "statusCode": 201,
          "message": "successfully updated data",
          "data": {
              "id": "5bbc0a9a-e4df-4eaa-af47-60cfbaffb2cf",
              "title": "seni untuk bersikap bodo amat",
              "author": "mark manson",
              "yearPublished": "2018"
          }
      }
     ```
7. Delete Book By ID
   - Endpoint   : `api/books/{id}`
   - Method     : DELETE
   - Response   :
     ```JSON
      {
          "statusCode": 200,
          "message": "successfully deleted data",
          "data": null
      }
     ```
     
