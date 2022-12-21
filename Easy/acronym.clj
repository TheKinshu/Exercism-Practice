(ns acronym (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (let [upper-phrase (str/upper-case phrase)
        phrase-list (str/split upper-phrase #"(\s+)")]
    (apply str (map first phrase-list))))



(defn acronym2
  "Converts phrase to its acronym."
  [phrase]
  (let [phrase-list (str/split phrase #"\s+")]
    (apply str (map first phrase-list))))


(acronym/acronym "Portable Network Graphics")