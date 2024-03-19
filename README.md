# Library API APP
![Library API APP](https://github.com/Leeroyakbar/library_api/assets/71091549/2ee58d02-0e24-4946-931a-fe5637616d0f)

`Library API APP` merupakan Sebuah applikasi API untuk melakukan pencatatan peminjaman buku di perpustakaan. API ini merupakan sistem yang memungkinkan pengguna untuk melakukan berbagai tindakan seperti peminjaman buku, pendaftaran anggota baru perpustakaan, manajemen katalog buku, dan proses peminjaman serta pengembalian buku.

*API ini dibuat menggunakan Java dengan Spring Framework*

## Endpoint Usage
---
#### Create New Book
   - Endpoint : `/api/books`
   - Method   : POST
   - Body
     ```JSON
     {
        "title": "seni untuk bersikap bodo amat",
        "author": "mark manson",
        "yearPublished": "2022"
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
#### Get Book By ID
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
---
#### Create New Loan
   - Endpoint   : `/api/loans`
   - Method     : POST
   - Body       :
     ```JSON
      {
          "memberId" : "f08efbb6-116d-48a5-b8da-89da18a0bb5d",
          "bookId" : "d7e7eee1-2512-43ea-8c1a-96e872a5f886"
      }
     ```
   - Response    :
     ```JSON
      {
          "statusCode": 201,
          "message": "successfully created data",
          "data": {
              "id": "67bbfc57-1033-40f5-a1e2-74f0c5391c23",
              "memberId": "fee8c596-61c4-4719-9745-396b582ceb55",
              "bookId": "5d4b024d-0901-4c31-84a2-34efc67b9a6c",
              "loanDate": "2024-03-18T00:05:43.480+00:00",
              "dateOfReturn": null,
              "status": "loaned"
          }
      }
     ```
#### Get All Loans
   - Endpoint   : `/api/loans`
   - Method     : GET
   - Response   :
     ```JSON
      {
          "statusCode": 200,
          "message": "successfully get data",
          "data": [
              {
                  "id": "69cc8a07-4cbf-4fdc-b658-2a2e2c0baead",
                  "memberId": "f08efbb6-116d-48a5-b8da-89da18a0bb5d",
                  "bookId": "d7e7eee1-2512-43ea-8c1a-96e872a5f886",
                  "loanDate": "2024-03-17T13:34:34.012+00:00",
                  "dateOfReturn": "2024-03-17T14:18:56.535+00:00",
                  "status": "returned"
              },
              {
                  "id": "67bbfc57-1033-40f5-a1e2-74f0c5391c23",
                  "memberId": "fee8c596-61c4-4719-9745-396b582ceb55",
                  "bookId": "5d4b024d-0901-4c31-84a2-34efc67b9a6c",
                  "loanDate": "2024-03-18T00:05:43.480+00:00",
                  "dateOfReturn": null,
                  "status": "loaned"
              }
          ]
      }
     ```

#### Update Status Loan
   - Endpoint   : `/api/loans/status`
   - Method     : PUT
   - Body       :
     ```JSON
      {
          "id" : "67bbfc57-1033-40f5-a1e2-74f0c5391c23",
          "status" : "returned"
      }
     ```
   - Response   :
     ```JSON
      {
          "statusCode": 201,
          "message": "successfully updated data",
          "data": {
              "id": "67bbfc57-1033-40f5-a1e2-74f0c5391c23",
              "memberId": "fee8c596-61c4-4719-9745-396b582ceb55",
              "bookId": "5d4b024d-0901-4c31-84a2-34efc67b9a6c",
              "loanDate": "2024-03-18T00:05:43.480+00:00",
              "dateOfReturn": "2024-03-18T00:09:06.197+00:00",
              "status": "returned"
          }
      }
     ```

