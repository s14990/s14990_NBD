db.people.mapReduce(
    function () {
        emit(this.job, null)
    },
    function () {},
    {out: 'zapytanie_3_MR'}
);

printjson(db.zapytanie_3_MR.find().toArray());