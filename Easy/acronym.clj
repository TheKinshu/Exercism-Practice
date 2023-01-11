(ns acronym (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" phrase)
       (map first)
       (apply str)
       (str/upper-case)))


(acronym/acronym "Portable Network Graphics")
(acronym/acronym "Ruby on Rails")
(acronym/acronym "HyperText Markup Language")
(acronym/acronym "First In, First Out")
(acronym/acronym "PHP: Hypertext Preprocessor")
(acronym/acronym "Complementary metal-oxide semiconductor")