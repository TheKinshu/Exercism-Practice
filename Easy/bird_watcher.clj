(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

;; return todays count
(defn today [birds]
  (peek birds))

;; increase today count of birds by 1
(defn inc-bird [birds]
  (assoc birds 6 (inc (today birds))))

;; check if there was a day without birds
(defn day-without-birds? [birds]
  (= (some #{0} birds) 0))

;; add all the numbers of birds visited base on n days
(defn n-days-count [birds n]
  (reduce + (take n birds)))

;; check how many days there is that has 5 or more birds
(defn busy-days [birds]
  (reduce + (filter #{> 5} birds)))


;; check the odd number of the element and see if there 
;; there is an alternating pattern
;; i.e. [1 0 1 0 1 0 1]
;; if the pattern is alternating by 1 and 0 the total added
;; should be the size of the odd-list 

(defn odd-week? [birds]
  (let [x (take-nth 2 birds)
        y (count (take-nth 2 birds))]
    (= (reduce + x) y)))


;; -------------------------------------------------------
;; other solution

(def last-week2 [1 0 1 0 1 0 1])

(= last-week2 (take (count last-week2) (cycle [1 0])))
