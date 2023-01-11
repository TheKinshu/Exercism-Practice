(ns anagram (:require [clojure.string :as string]))

(defn check-anagram [word1 word2]
  (let [pre-sort1 (string/lower-case word1)
        pre-sort2 (string/lower-case word2)
        w1 (sort pre-sort1)
        w2 (sort pre-sort2)
        result (and (not= pre-sort1 pre-sort2)
                    (= w1 w2))]
    result))

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (filter (partial check-anagram word) prospect-list))
