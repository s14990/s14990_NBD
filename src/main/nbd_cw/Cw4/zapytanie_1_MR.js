db.people.mapReduce(
    function () {
        emit(this.sex, {
            weight: this.weight,
            height: this.height,
        });
    },

    function (key, values) {
        let totalWeight = 0;
        let totalHeight = 0;
        let totalCount = values.length;

        for (var idx = 0; idx < totalCount; idx++) {
            totalWeight += values[idx].weight;
            totalHeight += values[idx].height;
        }

        return {
            averageWeight: totalWeight / totalCount,
            averageHeight: totalHeight / totalCount
        };
    },
    {out: 'zapytanie_1_MR'}
);

printjson(db.zapytanie_1_MR.find().toArray());