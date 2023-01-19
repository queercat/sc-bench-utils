using import .time
using import Array
using import format

fn create-array ()
    for x in (range 0 100)
        local values = ((Array i64))
        for y in (range 0 10000)
            'append values y

let iterations = 100
let average-time = (time-trial create-array iterations)

print 
    .. (format "on average {} took {}s over {} iterations" (average-time @ 1) (average-time @ 0) iterations)

fn create-array-with-args (value)
    for x in (range 0 100)
        local values = ((Array i64))
        for y in (range 0 (pow 10 1))
            'append values value

let iterations = (pow 10 5) 
let average-time = (time-trial create-array-with-args iterations 0)

print 
    .. (format "on average {} took {}s over {} iterations" (average-time @ 1) (average-time @ 0) iterations)
