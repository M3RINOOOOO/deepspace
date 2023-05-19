#encoding:utf-8
require_relative "Dice.rb"
require_relative "Weapon.rb"
require_relative "ShieldBooster.rb"
require_relative "SuppliesPackage.rb"
require_relative "GameCharacter.rb"
require_relative "Loot.rb"
require_relative "WeaponType.rb"


module Deepspace 
	class TestP1
		def initialize()
			@dice=Dice.new
		end
        def dice()
			@dice
		end
	end
end

arma = Deepspace::Weapon.new("arma",Deepspace::WeaponType::LASER,2)
shieldbooster = Deepspace::ShieldBooster.new("prueba",1,2)
suppliespackage = Deepspace::SuppliesPackage.new(1,2,3)
loot = Deepspace::Loot.new(1,2,3,4,5)
puts
puts arma
puts
puts shieldbooster
puts
puts suppliespackage
puts
puts loot
puts

a = Deepspace::TestP1.new

first_valueH = 0
second_valueH = 0
first_valueW = 0
second_valueW = 0
third_valueW = 0
first_valueS = 0
second_valueS = 0
first_valueWh = 0
second_valueWh = 0
first_valueSh = 0
second_valueSh = 0
first_valueSm = 0
second_valueSm = 0

100.times do
    #initWithNHangars
    if a.dice.initWithNHangars() <1
        first_valueH +=1 
    else    
        second_valueH +=1    
    end
    
    #initWithNWeapons
    aux =  a.dice.initWithNWeapons()
    if aux <2
        first_valueW +=1 
    elsif aux <3
        second_valueW +=1   
    else 
        third_valueW +=1 
    end

    #initWithNShields
    if a.dice.initWithNShields() <1
        first_valueS +=1 
    else    
        second_valueS +=1    
    end

    #whoStarts
     if a.dice.whoStarts(2) < 1 
        first_valueWh +=1
    else 
        second_valueWh +=1    
           
     end        

    #firstShot
    if a.dice.firstShot==Deepspace::GameCharacter::SPACESTATION 
        first_valueSh +=1
    else 
        second_valueSh +=1    
           
    end   
    
    #spaceStationMoves
    if a.dice.spaceStationMoves(0.5)  
        first_valueSm +=1
    else 
        second_valueSm +=1    
           
     end   
end

puts "PROBANDO initWithNHangars"
puts "Ha salido 0 " + first_valueH.to_s + " veces (debería salir cerca de 25)"
puts "Ha salido 1 " + second_valueH.to_s + " veces (debería salir cerca de 75)"
puts 

puts "PROBANDO initWithNWeapons"
puts "Ha salido 1 " + first_valueW.to_s + " veces (debería salir cerca de 33)"
puts "Ha salido 2 " + second_valueW.to_s + " veces (debería salir cerca de 33)"
puts "Ha salido 3 " + third_valueW.to_s + " veces (debería salir cerca de 33)"
puts

puts "PROBANDO initWithNShields"
puts "Ha salido 0 " + first_valueS.to_s + " veces (debería salir cerca de 25)"
puts "Ha salido 1 " + second_valueS.to_s + " veces (debería salir cerca de 75)"
puts 

puts "PROBANDO whoStarts"
puts "Ha salido 0 " + first_valueWh.to_s + " veces (debería salir cerca de 50)"
puts "Ha salido 1 " + second_valueWh.to_s + " veces (debería salir cerca de 50)"
puts 

puts "PROBANDO firstShot"
puts "Ha salido SPACESTATION " + first_valueSh.to_s + " veces (debería salir cerca de 50)"
puts "Ha salido ENEMYSTARSHIP " + second_valueSh.to_s + " veces (debería salir cerca de 50)"
puts 

puts "PROBANDO spaceStationMoves"
puts "Ha salido true " + first_valueSm.to_s + " veces (debería salir cerca de 50)"
puts "Ha salido false " + second_valueSm.to_s + " veces (debería salir cerca de 50)"
puts 

