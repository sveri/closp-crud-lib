(ns de.sveri.clospcrud.dt-to-hiccup-test
  (:require [clojure.test :refer :all]
            [de.sveri.clospcrud.td-to-hiccup :as tth]))

(def int-c [:id :int :null false :pk true :autoinc true])
(def varchar-c [:name [:varchar 40] :null false :pk true])
(def varchar-invalid-c [:name [:varchar] :null false :pk true])
(def char-c [:name [:char 40] :null false :pk true])
(def bool-c [:male :boolean :default true])
(def underscore-col-name [:male_human :boolean :default true])

(deftest conv-int
  (is (= [[:label {:for "id"} "id"] [:input.form-control {:id "id" :required "required" :name "id"
                                                          :value "{{fooname.id}}"}]]
         (tth/dt->hiccup int-c "fooname" :create))))

(deftest conv-varchar
  (is (= [[:label {:for "name"} "name"]
          [:input.form-control {:id "name" :required "required" :maxlength 40 :name "name" :value "{{fooname.name}}"}]]
         (tth/dt->hiccup varchar-c "fooname" :create)))
  (is (thrown? AssertionError (tth/dt->hiccup varchar-invalid-c "fooname" :create))))

(deftest conv-char
  (is (= [[:label {:for "name"} "name"]
          [:input.form-control {:id "name" :required "required" :maxlength 40 :name "name" :value "{{fooname.name}}"}]]
         (tth/dt->hiccup char-c "fooname" :create))))

(deftest conv-boolean
  (is (= [[:label [:input.form-control {:id "male" :checked "checked" :name "male" :type "checkbox"}] "male"]]
         (tth/dt->hiccup bool-c "fooname" :create)))
  (is (= [[:label [:input.form-control {:id "male" :name "male" :type "checkbox"}] "male"]]
         (tth/dt->hiccup (assoc bool-c 3 false) "fooname" :create))))

(deftest conv-boolean
  (is (= [[:label [:input.form-control {:id "male_human" :checked "checked" :name "male_human" :type "checkbox"}] "male_human"]]
         (tth/dt->hiccup underscore-col-name "fooname" :create))))
