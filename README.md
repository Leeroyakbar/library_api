# Library API APP
![Library API APP](https://github.com/Leeroyakbar/library_api/assets/71091549/2ee58d02-0e24-4946-931a-fe5637616d0f)

`Library API APP` merupakan Sebuah applikasi API untuk melakukan pencatatan peminjaman buku di perpustakaan. API ini merupakan sistem yan gmemungkinkan pengguna untuk melakukan berbagai tindakan seperti peminjaman buku, pendaftaran anggota baru perpustakaan, manajemen katalog buku, dan proses peminjaman serta pengembalian buku.

*API ini dibuat menggunakan Java dengan Spring Framework*

## Endpoint Usage
---
#### Create New Book
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
#### Get Book
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

#### Get All Books
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
#### Update Book
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
#### Delete Book By ID
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
---

#### Create New Member
   - Endpoint   : `/api/members`
   - Method     : POST
   - Body       :
     ```JSON
      {
          "name": "lee",
          "address": "Jl. Topaz No.7",
          "mobilePhone" : "081234567"
      }
     ```
   - Response   :
     ```JSON
      {
          "statusCode": 201,
          "message": "successfully created data",
          "data": {
              "id": "40bf436e-b6bf-4480-88fb-5d63f3196e76",
              "name": "lee",
              "address": "Jl. Topaz No.7",
              "mobilePhone": "081234567"
          }
      }
     ```
#### Get Member By ID
   - Endpoint   : `/api/members/{id}`
   - Method     : GET
   - Response   :
     ```JSON
      {
          "statusCode": 200,
          "message": "successfully get data",
          "data": {
              "id": "40bf436e-b6bf-4480-88fb-5d63f3196e76",
              "name": "lee",
              "address": "Jl. Topaz No.7",
              "mobilePhone": "081234567"
          }
      }
     ```
#### Get All Members
   - Endpoint   : `/api/members`
   - Method     : GET
   - Response   :
     ```JSON
      {
          "statusCode": 200,
          "message": "successfully get data",
          "data": [
              {
                  "id": "f08efbb6-116d-48a5-b8da-89da18a0bb5d",
                  "name": "roy",
                  "address": "Jl. Topaz No.7",
                  "mobilePhone": "089912356"
              },
              {
                  "id": "40bf436e-b6bf-4480-88fb-5d63f3196e76",
                  "name": "lee",
                  "address": "Jl. Topaz No.7",
                  "mobilePhone": "081234567"
              }
          ]
      }
     ```
#### Update Member
   - Endpoint   : `/api/members`
   - Method     : PUT
   - Body       :
     ```JSON
     {
        "id": "40bf436e-b6bf-4480-88fb-5d63f3196e76",
        "name": "lee roy",
        "address": "Jl. Topaz No.7",
        "mobilePhone": "081234567"
     }
     ```
   - Response    :
     ```JSON
      {
          "statusCode": 201,
          "message": "successfully updated data",
          "data": {
              "id": "40bf436e-b6bf-4480-88fb-5d63f3196e76",
              "name": "lee",
              "address": "Jl. Topaz No.7",
              "mobilePhone": "081234567"
          }
      }
     ```
#### Delete Member By ID
   - Endpoint   : `/api/members/{id}`
   - Method     : DELETE
   - Response   :
     ```JSON
      {
          "statusCode": 200,
          "message": "successfully deleted data",
          "data": null
      }
     ```
