(ns acronym (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (let [phrase-list (re-seq #"[A-Z]+[a-z]*|\w+" phrase)]
    phrase-list))
(acronym/acronym "Portable Network Graphics")
