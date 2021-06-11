printjson(
    db.people.insert({
        sex: "Male",
        first_name: "Dmytro",
        last_name: "Demidenko",
        job: "student",
        email: "s14990@pjwstk.edu.pl",
        location: {
            city: "Warsaw",
            address: {
                streetname: "A",
                streetnumber: "1"
            }
        },
        description: "none",
        height: 80,
        weight: 180,
        birth_date: new ISODate("2013-05-23T16:10:58Z"),
        nationality: "Ukraine",
        credit: [
            {
                type: 'R',
                number: '1',
                currency: '$',
                balance: '1'
            }
        ]
    })
)