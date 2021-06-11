printjson(db.people.aggregate([
    {$group: {_id: "$sex", averageWeight: {$avg: "$weight"}, averageHeight: {$avg: "$height"}}}
]).toArray())