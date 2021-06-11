printjson(db.people.aggregate([
    {
        $group: {
            _id: "$nationality",
            avg: {$avg: {$divide: ["$weight", {$pow: [{$divide: ["$height", 100]}, 2]}]}},
            min: {$min: {$divide: ["$weight", {$pow: [{$divide: ["$height", 100]}, 2]}]}},
            max: {$max: {$divide: ["$weight", {$pow: [{$divide: ["$height", 100]}, 2]}]}}
        }
    }
]).toArray())