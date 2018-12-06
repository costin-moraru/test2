// Import Libraries
import { ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

// Import Services
import { AssetService } from '../../services/asset.service';
import { UserService } from '../../services/user.service';

// Import Models
import { Asset } from '../../domain/test2_db/asset';
import { User } from '../../domain/test2_db/user';
// START - USED SERVICES
/*
 *	assetService.create
 *		PARAMS: 
 *		
 *
 *	assetService.get
 *		PARAMS: 
 *					ObjectId id - Id 
 *		
 *
 *	UserService.list
 *		PARAMS: 
 *		
 *
 *	assetService.update
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * UserService  
 * assetService  
 */
// END - REQUIRED RESOURCES

/**
 * Edit component for assetEdit
 */
@Component({
    selector: 'asset-edit',
    templateUrl : './asset-edit.component.html',
    styleUrls: ['./asset-edit.component.css']
})
export class AssetEditComponent implements OnInit {

    item: Asset;
    listFk_asset_user: User[];
    model: Asset;
    
    constructor(
        private assetService: AssetService,
        private userService: UserService,
        private route: ActivatedRoute,
        private location: Location) {
        // Init item
        this.item = new Asset();
    }

    ngOnInit(): void {
            this.route.params.subscribe(param => {
                let id: string = param['id'];
                if (id !== 'new') {
                    // Get item from server 
                    this.assetService.get(id).subscribe(item => this.item = item);
                    
                    
                }
                this.fk_asset_userervice.list().subscribe(list => this.listFk_asset_user = list);
            });
    }

    /**
     * Save Item
     */
    save (formValid:boolean, item: Asset): void{
        if (formValid) {
            if(item._id){
                this.assetService.update(item).subscribe(data => this.goBack());
            } else {
                this.assetService.create(item).subscribe(data => this.goBack());
            }  
        }
    }

    /**
     * Go Back
     */
    goBack(): void {
        this.location.back();
    }
    

}