using import format
using import String

let time = (include "time.h")

fn get-time ()
    local timespec-struct =
        (time.struct.timespec)

    (time.extern.clock_gettime 1 &timespec-struct)

    let ns = 
        (timespec-struct.tv_nsec / (pow 10 9))
    let s = 
        (timespec-struct.tv_sec as f64) 

    # time since epoch
    let tse =
        s + ns

inline time-it (func args...)
    local start-time = (get-time)
    call func args...
    local end-time = (get-time)

    let duration = (end-time - start-time)
    (tupleof duration func)

inline time-trial (func iterations args...) 
    local average-time = 0:f64
    for _ in (range 0 iterations)
        average-time += ((time-it func args...) @ 0)
    
    average-time /= iterations
    (tupleof average-time func)
    
locals;

