Feature: Booking Kost

  Scenario Outline: kost seeker successfully make a booking without complete the entry requirements documents because it's set to optional
    Given user logged in as a tenant with credential "<phoneNumber>" and "<password>"
    * user navigates to kost Detail Page by url "<url>"
    When user enters "<dateCheckin>" into the text input checkin
    * user inputs "<bookingRentType>" into DDL booking rent type
    * user submit booking request
    * user submit booking request form
    * user checks agreement letter on kost information page
    * user clicks button kirim pengajuan ke pemilik
    Then user should be directed to booking success page
    * message "Pengajuan sewa berhasil dikirim" should be visible
    * button lihat status pengajuan should be visible

    Examples: booking data
      | phoneNumber | password | url | dateCheckin | bookingRentType |
      | 08111096967 | mamikos2022 | https://mamikos.com/room/kost-kabupaten-simeulue-kost-campur-eksklusif-kos-agen-duo-tenant-1#/ | tomorrow | Per Bulan |


    Scenario Outline: kost seeker failed make a booking because kamar kost penuh
      Given user logged in as a tenant with credential "<phoneNumber>" and "<password>"
      When user navigates to kost Detail Page by url "<url>"
      Then icon kamar penuh will be shown

      Examples: booking data
        | phoneNumber | password | url |
        | 08111096967 | mamikos2022 | https://mamikos.com/room/kost-kabupaten-simeulue-kost-campur-eksklusif-kos-agen-duo-tenant-1#/ |


      Scenario Outline: kost seeker can't continue booking kost because he hasn't login yet
        Given user navigates to kost Detail Page by url "<url>"
        When user enters "<dateCheckin>" into the text input checkin
        * user inputs "<bookingRentType>" into DDL booking rent type
        * user submit booking request
        Then modal login will be shown

        Examples: booking data
        | url | dateCheckin| bookingRentType|
        | https://mamikos.com/room/kost-kabupaten-simeulue-kost-campur-eksklusif-kos-agen-duo-tenant-1#/ | tomorrow | Per Bulan |


