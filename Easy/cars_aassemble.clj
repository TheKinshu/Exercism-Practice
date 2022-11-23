(ns cars-assemble)

(defn production-rate
  [speed]
  (let [rate 221]
    (cond
      (= speed 0) 0.0
      (< speed 5) (float (* speed rate))
      (< speed 9) (* 0.9 (* speed rate))
      (= speed 9) (* 0.8 (* speed rate))
      (= speed 10) (* 0.77 (* speed rate)))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (let [rate (/ 221 60)]
    (cond
      (= speed 0) 0
      (< speed 5) (int (* speed rate))
      (< speed 9) (int (* 0.9 (* speed rate)))
      (= speed 9) (int (* 0.8 (* speed rate)))
      (= speed 10) (int (* 0.77 (* speed rate))))))
